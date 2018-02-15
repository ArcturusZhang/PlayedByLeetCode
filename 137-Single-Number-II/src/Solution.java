public abstract class Solution {
    public abstract int singleNumber(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.singleNumber(1, 1, 1, 2, 2, 2, 3, 5, 5, 6, 6, 4, 4, 5, 4, 6));
    }
}
