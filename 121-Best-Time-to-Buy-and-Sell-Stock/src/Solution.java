public abstract class Solution {
    public abstract int maxProfit(int... prices);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.maxProfit(7, 1, 5, 3, 6, 4));
        System.out.println(solution.maxProfit(7, 6, 4, 3, 1));
    }
}
