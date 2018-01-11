public abstract class Solution {
    public abstract int maxProfit(int k, int[] prices);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.maxProfit(1, new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(2, new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(3, new int[] {7, 6, 4, 10, 1}));
        System.out.println(solution.maxProfit(1, new int[] {7, 6, 4, 10, 1}));
    }
}
