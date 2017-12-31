import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/unique-paths/description/</url>
     * 解：
     * 动态规划。记dp(i,j)为机器人到达i,j格子的走法数目。那么机器人要么从i-1,j格走到i,j格，要么就是从i,j-1格走到i,j格（因为机器人只能向右或者向下走）
     * 所以状态转移方程为
     * dp(i,j) = dp(i-1,j) + dp(i,j-1)
     * 边界条件为
     * dp(0,j) = 1
     * dp(i,0) = 1
     * @param m
     * @param n
     * @return
     */
    @Override
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
