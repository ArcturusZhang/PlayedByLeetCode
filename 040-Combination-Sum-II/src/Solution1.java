import java.util.*;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/combination-sum-ii/description/</url>
     * 解：
     * 回溯法。本题与Combination Sum的区别是候选元素中可能有重复数字，且每个元素只能在解中出现一次。
     * 所以我为了方便使用Set来去除可能产生的重复解（重复元素往往会造成重复解）。也可以用{@code Solution2}中的方法来去除重复解。
     * @param candidates
     * @param target
     * @see Solution2
     * @return
     */
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        combinationCore(candidates, target, 0, result, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void combinationCore(int[] candidates, int target, int idx, Set<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0 && idx < candidates.length) {
            for (int i = idx; i < candidates.length; i++) {
                current.add(candidates[i]);
                combinationCore(candidates, target - candidates[i], i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
