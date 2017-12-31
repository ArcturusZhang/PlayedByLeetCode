public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/minimum-path-sum/description/</url>
     * 解：
     * 动态规划。记dp(i,j)为从左上到(i,j)格子的所有路径中最小的和。由于在第一行和第一列只有一条路径可走，所以边界条件为：
     * dp(0,0) = grid(0,0)
     * dp(0,j) = grid(0,j) + dp(0,j-1)，简单按行求和
     * dp(i,0) = grid(i,0) + dp(i-1,0)，简单按列求和
     * dp(i,j) = grid(i,j) + min(dp(i-1,j) + dp(i,j-1))
     * @param grid
     * @return
     */
    @Override
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 第一行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = grid[0][col] + dp[0][col - 1];
        }
        // 第一列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = grid[row][0] + dp[row - 1][0];
        }
        // 其余区域
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = grid[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
