public abstract class Solution {
    public abstract boolean isNumber(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isNumber("1.E80"));
        System.out.println(solution.isNumber("1.E8.0"));
        System.out.println(solution.isNumber("1.d8.0"));
        System.out.println(solution.isNumber("+1.E-80"));
        System.out.println(solution.isNumber("-1937401"));
        System.out.println(solution.isNumber("-1937f401"));
        System.out.println(solution.isNumber("-1937.401"));
        System.out.println(solution.isNumber("-1937.4.01"));
        System.out.println(solution.isNumber("-.01"));
    }
}
