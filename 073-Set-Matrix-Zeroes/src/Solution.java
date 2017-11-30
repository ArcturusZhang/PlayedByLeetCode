import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        // 遍历矩阵，如果某一行中有元素为零，就将这一行的第一个元素设为0；如果某一列有元素为零，就将这一列的第一个元素设为0
        // 如果第一行或第一列有元素为零，就将两个Flag中相应的变量设为true
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) rowFlag = true;
                    if (j == 0) colFlag = true;
                }
            }
        }
        // 遍历第一行以外的部分，如果该行第一个元素为零，就将该行所有元素设为零。
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) matrix[i][j] = 0;
            }
        }
        // 遍历第一列以外的部分，如果该列第一个元素为零，就将该列所有元素设为零。
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) matrix[i][j] = 0;
            }
        }
        // 处理第一行有零的情形
        if (rowFlag) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        // 处理第一列有零的情形
        if (colFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 9},
                {0, 11, 12}
        };
        solution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
