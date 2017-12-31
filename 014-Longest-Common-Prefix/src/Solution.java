public abstract class Solution {
    public abstract String longestCommonPrefix(String... strs);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.longestCommonPrefix("ajfmc", "ajfq", "ajfdafmc", "ajfmaeaafc"));
    }
}
