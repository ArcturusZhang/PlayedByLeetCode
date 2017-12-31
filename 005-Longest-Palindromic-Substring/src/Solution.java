public abstract class Solution {
    public abstract String longestPalindrome(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("polamc"));
        System.out.println(solution.longestPalindrome("ab"));
        System.out.println(solution.longestPalindrome("aa"));
    }
}
