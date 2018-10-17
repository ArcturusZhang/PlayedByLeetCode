public class Solution1 extends Solution {
    @Override
    public int rob(int[] nums) {
        int first = rob(nums, 0, nums.length - 2);
        int skipFirst = rob(nums, 1, nums.length - 1);
        return Math.max(first, skipFirst);
    }

    private int rob(int[] nums, int left, int right) {
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        for (int i = left + 1; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], i >= 2 ? dp[i - 2] + nums[i] : 0);
        }
        return dp[right];
    }
}
