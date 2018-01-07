import arcturus.util.ArrayUtils;

import java.util.Arrays;

public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/number-of-islands/description/</url>
     * @param grid
     * @return
     */
    public abstract int numIslands(char[][] grid);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] grid = ArrayUtils.gridConstructor("11000, 11000, 00100, 00011");
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(solution.numIslands(grid));
        grid = ArrayUtils.gridConstructor("11110\n" + "11010\n" + "11000\n" + "00000", "\n");
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(solution.numIslands(grid));
    }
}
