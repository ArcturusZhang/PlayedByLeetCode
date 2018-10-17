public abstract class Solution {
    public abstract int candy(int[] ratings);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.candy(new int[] {1, 0, 2})); // 5
    }
}
