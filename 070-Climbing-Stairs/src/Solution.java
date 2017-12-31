public abstract class Solution {
    public abstract int climbStairs(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(10));
    }
}
