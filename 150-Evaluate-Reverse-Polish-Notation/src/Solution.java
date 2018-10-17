public abstract class Solution {
    public abstract int evalRPN(String[] tokens);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
    }
}
