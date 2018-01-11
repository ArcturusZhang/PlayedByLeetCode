public class Solution1 extends Solution {
    private static final int TRANSACTIONS = 2;

    /**
     * 解：
     * 动态规划。注：本解法已经适用于任意k次转手上限的情形。
     * 记dp(k,i+1)表示“以不超过k次转手，到第i天为止（包括第i天）”所能获得的最大利润。那么显然边界条件为
     * dp(0,i+1) = 0，不进行转手必然没有利润
     * dp(k,0) = 0，相当于在第-1天，这是初始状态，也没有利润
     * 状态转移方程：
     * dp(k,i+1) = max(dp(k,i), max(prices[i] - prices[j] + f(k-1,j)))
     * 其中j从0到i-1。这个式子可以变形为
     * dp(k,i+1) = max(dp(k,i), max(f(k-1,j) - prices[j]) + prices[i])
     * 可以利用一个临时变量来储存迄今为止f(k-1,j) - prices[j]的最大值。
     * 按照上面的步骤得到所有的dp值之后，其中的最大值即为所求的最大利润。
     * @param prices
     * @return
     */
    @Override
    public int maxProfit(int... prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[TRANSACTIONS + 1][prices.length + 1];
        int max = 0;
        for (int k = 1; k <= TRANSACTIONS; k++) {
            int tmpMax = dp[k - 1][0] - prices[0];
            for (int i = 0; i < prices.length; i++) {
                dp[k][i + 1] = Math.max(dp[k][i], tmpMax + prices[i]);
                tmpMax = Math.max(dp[k - 1][i] - prices[i], tmpMax);
                max = Math.max(max, dp[k][i + 1]);
            }
        }
        return max;
    }
}
