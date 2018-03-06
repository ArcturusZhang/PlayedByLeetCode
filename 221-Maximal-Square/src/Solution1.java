public class Solution1 extends Solution {
    /**
     * 动态规划
     * 记dp(i,j)表示以(i,j)为右下角的最大正方形边长。显然对于第一行和第一列，当格子为0时dp(i,j) = 0，否则dp(i,j) = 1（边界条件）
     * 转移方程也很容易。当(i,j)为0时，必然有dp(i,j) = 0
     * 当(i,j)非0时，则dp(i,j) = min(dp(i-1,j), dp(i,j-1), dp(i-1,j-1)) + 1，在左上角处的正方形周围再增加一层。
     * 在这个过程中维护一个记录最大正方形边长的变量，最后返回面积即可。
     * @param matrix
     * @return
     */
    @Override
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        // 第一行
        for (int col = 0; col < cols; col++) {
            dp[0][col] = matrix[0][col] == '1' ? 1 : 0;
            if (dp[0][col] > max) max = dp[0][col];
        }
        // 第一列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = matrix[row][0] == '1' ? 1 : 0;
            if (dp[row][0] > max) max = dp[row][0];
        }
        // 其余部分
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1]) + 1;
                }
                if (dp[row][col] > max) max = dp[row][col];
            }
        }
        return max * max;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
