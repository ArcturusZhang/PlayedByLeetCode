import arcturus.util.ArrayUtils;

public abstract class Solution {
    public abstract int maxAreaOfIsland(char[][] grid);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] board = ArrayUtils.gridConstructor("0010000100000, 0000000111000, 0110100000000"
                            + "0110100000000, 0100110010100, 0100110011100, 0000000000100"
                            + "0000000111000, 0000000110000");
        System.out.println(ArrayUtils.gridToString(board));
        System.out.println(solution.maxAreaOfIsland(board));
        System.out.println(ArrayUtils.gridToString(board));
    }
}
