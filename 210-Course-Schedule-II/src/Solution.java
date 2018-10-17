import java.util.Arrays;

public abstract class Solution {
    public abstract int[] findOrder(int numCourses, int[][] prerequisites);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
