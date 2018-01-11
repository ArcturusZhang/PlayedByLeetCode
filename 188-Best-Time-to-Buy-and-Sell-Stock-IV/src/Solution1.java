public class Solution1 extends Solution {
    /**
     * 解：
     * 动态规划。本题解法已经在第123题中详细解释过，当然空间复杂度是可以优化的，因为每一层的递推中只利用了上一层的结果。
     * 这里对极端情况进行了额外考虑（重要！否则会超时）。
     * @param k
     * @param prices
     * @return
     */
    @Override
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length <= 1) return 0;
        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
            }
            return max;
        }
        int[][] dp = new int[k + 1][prices.length + 1];
        int max = 0;
        for (int kk = 1; kk <= k; kk++) {
            int tmpMax = dp[kk - 1][0] - prices[0];
            for (int i = 0; i < prices.length; i++) {
                dp[kk][i + 1] = Math.max(dp[kk][i], tmpMax + prices[i]);
                tmpMax = Math.max(tmpMax, dp[kk - 1][i] - prices[i]);
                max = Math.max(max, dp[kk][i + 1]);
            }
        }
        return max;
    }
}
