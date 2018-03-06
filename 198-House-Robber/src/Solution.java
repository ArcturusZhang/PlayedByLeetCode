public abstract class Solution {
    public abstract int rob(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.rob(2, 1, 1, 2));
    }
}
