import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 题目描述：<url>https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/</url>
     * 解：
     * 这题目有很多做法，我这个做法应该算是比较低效的，因为产生了很多无用的列表对象。
     * 如果将产生新列表的做法改为队列，应该会在空间上节约一些。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            List<String> newResult = new LinkedList<>();
            for (String prefix : result) {
                newResult.addAll(core(prefix, digit));
            }
            result = newResult;
        }
        return result;
    }

    private List<String> core(String prefix, int digit) {
        List<String> list = new LinkedList<>();
        for (char c : phone[digit].toCharArray()) {
            list.add(prefix + c);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("123"));
        System.out.println(solution.letterCombinations("213"));
    }
}
