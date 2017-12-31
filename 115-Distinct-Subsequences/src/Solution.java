public abstract class Solution {
    public abstract int numDistinct(String s, String t);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
    }
}
