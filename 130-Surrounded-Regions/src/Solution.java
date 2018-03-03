import arcturus.util.ArrayUtils;

public abstract class Solution {
    public abstract void solve(char[][] board);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] board = ArrayUtils.gridConstructor("XXXX, XOOX, XXOX, XOXX");
        System.out.println(ArrayUtils.gridToString(board, " "));
        solution.solve(board);
        System.out.println(ArrayUtils.gridToString(board, " "));
    }
}
