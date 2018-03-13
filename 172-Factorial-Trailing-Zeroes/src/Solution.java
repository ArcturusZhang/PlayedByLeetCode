public abstract class Solution {
    public abstract int trailingZeroes(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.trailingZeroes(6));
        System.out.println(solution.trailingZeroes(1466148335));
    }
}
