public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/maximal-rectangle/description/</url>
     * 解：
     * 动态规划。用dp(i,j)记录以(i,j)为左上角的最大矩形的面积。
     * 第一步先获得只含一行的矩形面积。（由于是左上角，所以需要倒序进行）转移方程为：
     * dp[i][j] = dp[i][j+1] + 1, if matrix[i][j] == '1'
     * dp[i][j] = 0, if matrix[i][j] == '0'
     * 第二步将上面得到的长条矩形按列进行合并。
     * 获得dp[i][j]: 依次扫描它下面的所有点(p,j)，获得最小的宽度，乘以高度(p-i+1)，记录如此得到的最大面积
     * @param matrix
     * @return
     */
    @Override
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + ((j + 1 < cols) ? dp[i][j + 1] : 0);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (dp[i][j] == 0) continue;
                int min = dp[i][j], area = dp[i][j];
                int p = i + 1;
                while (p < rows && dp[p][j] != 0) {
                    min = Math.min(min, dp[p][j]);
                    area = Math.max(area, (p - i + 1) * min);
                    p++;
                }
                dp[i][j] = area;
                if (area > max) max = area;
            }
        }
        return max;
    }
}
