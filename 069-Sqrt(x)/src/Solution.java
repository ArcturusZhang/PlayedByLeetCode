public abstract class Solution {
    public abstract int mySqrt(int x);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.mySqrt(Integer.MAX_VALUE));
        System.out.println(solution.mySqrt(19));
    }
}
