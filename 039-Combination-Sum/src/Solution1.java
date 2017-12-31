import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/combination-sum/description/</url>
     * 解：
     * 回溯法。
     * @param candidates
     * @param target
     * @return
     */
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates); // 排序以提高效率（非必需）
        combinationCore(candidates, target, 0, result, new ArrayList<>()); // 启动核心方法
        return result; // 返回结果
    }

    private void combinationCore(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // 出口
        } else if (target > 0) {
            for (int i = idx; i < candidates.length; i++) { // 尝试从idx开始的每个数字
                current.add(candidates[i]); // 将其加入尝试列表
                combinationCore(candidates, target - candidates[i], i, result, current); // 递归执行
                current.remove(current.size() - 1); // 进行回溯，以得到所有的解
            }
        }
    }
}
