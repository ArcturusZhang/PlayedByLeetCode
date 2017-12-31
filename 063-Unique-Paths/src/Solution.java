public abstract class Solution {
    public abstract int uniquePathsWithObstacles(int[][] obstacleGrid);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[][] obstacleGrid = new int[][]{
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][] {{1}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][] {{1, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
