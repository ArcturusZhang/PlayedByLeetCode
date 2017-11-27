import java.util.*;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/combination-sum-ii/description/</url>
     * 解：
     * 回溯法。本题与Combination Sum的区别是候选元素中可能有重复数字，且每个元素只能在解中出现一次。
     * 所以我为了方便使用Set来去除可能产生的重复解（重复元素往往会造成重复解）。也可以用{@code combinationCore2}中的方法来去除重复解。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        combinationCore(candidates, target, 0, result, new ArrayList<>());
        return new ArrayList<>(result);
    }

    public List<List<Integer>> combinationSum2Solution2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationCore2(candidates, target, 0, result, new ArrayList<>());
        return result;
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

    private void combinationCore2(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0 && idx < candidates.length) {
            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i - 1] == candidates[i]) continue; // 去除重复的解
                current.add(candidates[i]);
                combinationCore2(candidates, target - candidates[i], i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 3, 6, 7};
        System.out.println(solution.combinationSum2(nums, 7));
        System.out.println(solution.combinationSum2(nums, 6));
        System.out.println(solution.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        System.out.println(solution.combinationSum2Solution2(new int[] {10,1,2,7,6,1,5}, 8));
    }
}
