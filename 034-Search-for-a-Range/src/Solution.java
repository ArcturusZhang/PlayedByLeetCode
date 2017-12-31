import java.util.Arrays;

public abstract class Solution {
    public abstract int[] searchRange(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution.searchRange(nums, 6)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 7)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 10)));
        System.out.println(Arrays.toString(solution.searchRange(nums, 16)));
    }
}
