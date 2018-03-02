public abstract class Solution {
    public abstract boolean isScramble(String s1, String s2);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isScramble("rgtae", "great"));
        System.out.println(solution.isScramble("treag", "great"));
    }
}
