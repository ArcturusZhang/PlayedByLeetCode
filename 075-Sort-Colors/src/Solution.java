import java.util.Arrays;

public abstract class Solution {
    public abstract void sortColors(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {0, 2, 1, 2, 1, 1, 0, 0, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
