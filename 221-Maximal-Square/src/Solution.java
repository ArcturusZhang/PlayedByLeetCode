import arcturus.util.ArrayUtils;

public abstract class Solution {
    public abstract int maximalSquare(char[][] matrix);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] matrix = ArrayUtils.gridConstructor("10100, 10111, 11111, 10010");
        System.out.println(ArrayUtils.gridToString(matrix, " "));
        System.out.println(solution.maximalSquare(matrix));
    }
}
