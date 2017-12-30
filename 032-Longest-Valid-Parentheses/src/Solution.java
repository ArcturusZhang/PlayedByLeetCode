public abstract class Solution {
    public abstract int longestValidParentheses(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses("(()())"));
        System.out.println(solution.longestValidParentheses(")()()"));
        System.out.println(solution.longestValidParentheses(")()"));
        System.out.println(solution.longestValidParentheses("((((()"));
        System.out.println(solution.longestValidParentheses("((()"));
    }
}
