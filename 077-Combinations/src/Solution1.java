import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/combinations/description/</url>
     * 解：
     * 回溯法。
     * @param n
     * @param k
     * @return
     */
    @Override
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) return result;
        combineCore(n, 1, k, result, new ArrayList<>());
        return result;
    }

    private void combineCore(int n, int start, int k, List<List<Integer>> result, List<Integer> current) {
        if (k == 0) { // 回溯出口
            result.add(new ArrayList<>(current));
        } else {
            for (int i = start; i <= n; i++) { // 因为不能重复，前面的数字不再遍历，所以循环从指定位置开始向后进行
                current.add(i); // 加入当前数字
                combineCore(n, i + 1, k - 1, result, current); // 递归加入其他后续数字
                current.remove(current.size() - 1); // 进行回溯
            }
        }
    }
}
