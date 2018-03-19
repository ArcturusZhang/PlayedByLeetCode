public abstract class Solution {
    public abstract int countDigitOne(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.countDigitOne(4));
        System.out.println(solution.countDigitOne(18));
        System.out.println(solution.countDigitOne(45));
        System.out.println(solution.countDigitOne(100));
    }
}
