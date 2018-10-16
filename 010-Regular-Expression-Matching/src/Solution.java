public abstract class Solution {
    public abstract boolean isMatch(String s, String p);

    public static void main(String[] args) {
//        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isMatch("aa","a")); // false
        System.out.println(solution.isMatch("aa","aa")); // → true
        System.out.println(solution.isMatch("abc","a.c")); // → true
        System.out.println(solution.isMatch("abc","a..")); // → true
        System.out.println(solution.isMatch("abc","a..d")); // → false
        System.out.println(solution.isMatch("abc","a.d")); // → false
        System.out.println(solution.isMatch("aaa","aa")); // → false
        System.out.println(solution.isMatch("aa", "a*")); // → true
        System.out.println(solution.isMatch("aa", ".*")); // → true
        System.out.println(solution.isMatch("ab", ".*")); // → true
        System.out.println(solution.isMatch("aab", "c*a*b")); // → true
        System.out.println(solution.isMatch("aab", "c*aab")); // → true
        System.out.println(solution.isMatch("abcd", "d*")); // false
    }
}
