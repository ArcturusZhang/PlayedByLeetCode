import java.util.Arrays;

public abstract class Solution {
    public abstract void setZeroes(int[][] matrix);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
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
