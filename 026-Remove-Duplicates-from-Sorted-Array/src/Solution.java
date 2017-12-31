import java.util.Arrays;

public abstract class Solution {
    public abstract int removeDuplicates(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {1, 1, 2, 3, 4, 4, 5, 5};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
