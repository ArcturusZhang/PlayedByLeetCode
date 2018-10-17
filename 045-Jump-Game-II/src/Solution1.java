public class Solution1 extends Solution {
    /**
     * 动态规划（未优化）
     * 用dp[i]记录从起点到索引为i处所需要的最小步数，那么为了计算dp[i]
     * 需要对所有的j < i, 当a[j] >= i - j时，dp[i]取为所有dp[j] + 1的最小值。
     * 时间复杂度：O(N^2)，超时
     * 但实际上并不需要每次都从起点开始搜索，如果前面一次搜索停在j处，下次搜索也从j处开始即可
     * @param nums
     * @return
     */
    @Override
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        for (int i = 1, j = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
