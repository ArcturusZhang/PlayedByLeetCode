import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/restore-ip-addresses/description/</url>
     * 解：
     * 回溯法。用一个列表储存点的位置。
     * @param s
     * @return
     */
    @Override
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        restoreIPAddressesCore(s, 0, result, new ArrayList<>());
        return result;
    }

    private void restoreIPAddressesCore(String s, int start, List<String> result, List<Integer> current) {
        if (start == s.length() && current.size() == 4) { // 回溯出口
            result.add(convert(s, current));
        } else if (current.size() < 4 && start < s.length()) { // 回溯主体
            current.add(start); // 不由分说先在当前位置加个点
            restoreIPAddressesCore(s, start + 1, result, current); // 下一段数字是一位的
            if (s.charAt(start) != '0') { // 如果下一个数字是多位的，则不能由0开头
                restoreIPAddressesCore(s, start + 2, result, current); // 下一段数字是两位的
                if (start + 3 <= s.length() && Integer.valueOf(s.substring(start, start + 3)) < 256) {
                    restoreIPAddressesCore(s, start + 3, result, current); // 如果下一段数字是三位的，则这个数字必须小于256，且开头数字不能是0
                }
            }
            current.remove(current.size() - 1); // 进行回溯
        }
    }

    /**
     * 一个将点的位置列表转换为IP地址的方法
     * @param s
     * @param dots
     * @return
     */
    private String convert(String s, List<Integer> dots) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = dots.size() - 1; i > 0; i--) {
            sb.insert(dots.get(i), ".");
        }
        return sb.toString();
    }
}
