public abstract class Solution {
    public abstract int searchInsert(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 0));
    }
}
