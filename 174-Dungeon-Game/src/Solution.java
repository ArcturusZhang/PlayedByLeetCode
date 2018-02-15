public abstract class Solution {
    public abstract int calculateMinimumHP(int[][] dungeon);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[][] dungeon = new int[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
