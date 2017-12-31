import java.util.Arrays;

public abstract class Solution {
    public abstract void nextPermutation(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {4, 3, 2, 1};
        for (int i = 0; i < 24; i++) {
            solution.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
