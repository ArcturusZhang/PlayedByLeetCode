public abstract class Solution {
    public abstract int divide(int dividend, int divisor);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.divide(2, 5));
        System.out.println(solution.divide(Integer.MIN_VALUE, 1));
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
        System.out.println(solution.divide(Integer.MIN_VALUE, -2));
    }
}
