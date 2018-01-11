public abstract class Solution {
    public abstract boolean isIsomorphic(String s, String t);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
        testCases(new Solution3());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("ab", "aa"));
    }
}
