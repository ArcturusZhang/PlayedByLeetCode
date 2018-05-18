public abstract class Solution {
    public abstract boolean canFinish(int numCourses, int[][] prerequisites);

    public static void main(String[] args) {
//        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.canFinish(2, new int[][] {new int[] {1, 0}}));
        System.out.println(solution.canFinish(2, new int[][] {new int[] {1, 0}, new int[] {0, 1}}));
    }
}
