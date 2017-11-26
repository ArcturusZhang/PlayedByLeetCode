import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/permutations/description/</url>
     * 求解一个数组中所有元素的所有排列。
     * 解：
     * 回溯法。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        permute(nums, result, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // 回溯法的出口
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 如果列表中已经有此数字，则跳过之
                if (current.contains(nums[i])) continue;
                current.add(nums[i]); // 加入当前的数字
                permute(nums, result, current); // 递归进行余下的数字
                current.remove(current.size() - 1); // 回溯
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[] {1, 2, 3, 4}));
        System.out.println(solution.permute(new int[] {1, 2, 3, 4}).size());
    }
}
