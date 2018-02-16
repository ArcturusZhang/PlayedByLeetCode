public abstract class Solution {
    public abstract int rangeBitwiseAnd(int m, int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.rangeBitwiseAnd(5, 7));
        System.out.println(solution.rangeBitwiseAnd(7, 2147483645));
    }
}
