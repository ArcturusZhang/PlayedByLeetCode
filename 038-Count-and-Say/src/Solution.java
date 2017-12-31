public abstract class Solution {
    public abstract String countAndSay(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        for (int n = 0; n < 10; n++)
            System.out.println(n + ": " + solution.countAndSay(n));
    }
}
