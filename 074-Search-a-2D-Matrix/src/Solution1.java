public class Solution1 extends Solution {
    /**
     * 二分查找的变形
     * @param matrix
     * @param target
     * @return
     */
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1, col = 0;
        while (row >= 0 && col < cols) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
