public abstract class Solution {
    public abstract boolean isInterleave(String s1, String s2, String s3);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
