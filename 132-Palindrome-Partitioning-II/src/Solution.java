public abstract class Solution {
    public abstract int minCut(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.minCut("aab"));
    }
}
