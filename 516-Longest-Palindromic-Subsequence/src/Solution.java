public abstract class Solution {
    public abstract int longestPalindromeSubseq(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }
}
