public class Solution1 extends Solution {
    /**
     * 动态规划。
     * 记dp(i)为抢劫到第i个房子时获得的最大收益。首先dp(0) = nums(0), dp(1) = max(nums(0), nums(1))
     * 在抢劫到第i个房子的时候，可以选择放弃这间房子，收益是dp(i-1)，也可以选择抢劫这间房子，收益是dp(i-2) + nums(i)（因为不能相邻）
     * 所以
     * dp(i) = max(dp(i-1), dp(i-2)+nums(i))
     * 最后抢劫所得最大收益就是dp(n-1)
     * @param nums
     * @return
     */
    @Override
    public int rob(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
