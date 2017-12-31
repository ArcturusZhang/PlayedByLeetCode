public abstract class Solution {
    public abstract int uniquePaths(int m, int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(1, 7));
        System.out.println(solution.uniquePaths(2, 7));
        System.out.println(solution.uniquePaths(1, 1));
    }
}
