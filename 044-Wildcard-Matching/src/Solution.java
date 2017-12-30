public abstract class Solution {
    public abstract boolean isMatch(String string, String pattern);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isMatch("", ""));
        System.out.println(solution.isMatch("", "*"));
        System.out.println(solution.isMatch("a", "aa"));
        System.out.println(solution.isMatch("a", "a*"));
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("ap", "a?"));
        System.out.println(solution.isMatch("ap", "?a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", "?*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaab", "a*******b"));
    }
}
