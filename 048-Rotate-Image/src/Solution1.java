import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 顺时针旋转90度 = 转置 + 按列反序
     * @param matrix
     */
    @Override
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 转置
        for (int j = 0; j < cols; j++) {
            for (int i = j; i < rows; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 倒序所有的列
        int left = 0, right = cols - 1;
        while (left < right) {
            for (int i = 0; i < rows; i++) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
            }
            left++;
            right--;
        }
    }
}
