public abstract class Solution {
    public abstract String minWindow(String s, String t);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
