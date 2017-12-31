public abstract class Solution {
    public abstract int strStr(String haystack, String needle);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("hello", "helloooo"));
    }
}
