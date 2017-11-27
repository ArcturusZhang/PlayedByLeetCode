import java.util.*;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/permutations-ii/description/</url>
     * 解：
     * 回溯法。
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteCore(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void permuteCore(int[] nums, List<List<Integer>> result, List<Integer> current, Set<Integer> visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited.contains(i)) continue; // 如果此元素已使用过，则跳过
                if (i > 0 && nums[i - 1] == nums[i] && !visited.contains(i - 1)) continue; // 避免重复解
                current.add(nums[i]); // 加入本元素
                visited.add(i); // 记录本元素已被使用
                permuteCore(nums, result, current, visited); // 递归执行
                current.remove(current.size() - 1); // 回溯，移除本元素
                visited.remove(i); // 回溯，移除本元素使用记录
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[] {1, 2, 1}));
    }
}
