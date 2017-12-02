public class Solution {
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

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 4));
    }
}
