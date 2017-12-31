public abstract class Solution {
    public abstract double myPow(double x, int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2, -10));
    }
}
