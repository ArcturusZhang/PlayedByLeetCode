public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/unique-paths-ii/description/</url>
     * 解：
     * 动态规划。本题与062类似，用dp(i,j)记录机器人从起点走到i,j格的走法数目。
     * 边界条件有些区别，如果该格子处有障碍，那么走到该格子的走法数目必然为零。
     * 在第一行，如果某格子没有障碍，那么到这里的走法数目应该与它左方的格子相同。
     * 在第一列，如果某格子没有障碍，那么到这里的走法数目应该与它上方的格子相同。
     * 其他格子，走法遵循状态转移方程
     * dp(i,j) = dp(i-1,j) + dp(i,j-1)  （无障碍时，有障碍直接取零）
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // 第一行
        for (int col = 1; col < n; col++) {
            if (obstacleGrid[0][col] == 0)
                dp[0][col] = dp[0][col - 1];
            else
                dp[0][col] = 0;
        }
        // 第一列
        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 0)
                dp[row][0] = dp[row - 1][0];
            else
                dp[row][0] = 0;
        }
        // 其余区域
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (obstacleGrid[row][col] == 0)
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                else
                    dp[row][col] = 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][] {{1}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][] {{1, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
