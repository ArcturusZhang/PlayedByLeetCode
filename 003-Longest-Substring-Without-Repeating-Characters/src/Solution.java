public abstract class Solution {
    public abstract int lengthOfLongestSubstring(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        String string = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(string));
    }
}
