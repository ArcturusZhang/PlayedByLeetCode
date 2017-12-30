public abstract class Solution {
    public abstract int singleNumber(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.singleNumber(new int[] {1, 3, 3, 2, 2, 6, 7, 6, 7}));
    }
}
