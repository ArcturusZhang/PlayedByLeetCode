import arcturus.util.ArrayUtils;

public abstract class Solution {
    public abstract int removeDuplicates(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {1, 1, 1, 2, 2, 3, 4, 4, 4, 6, 6};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(ArrayUtils.toString(nums, 0, solution.removeDuplicates(nums)));
    }
}
