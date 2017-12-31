import java.util.Arrays;

public abstract class Solution {
    public abstract int removeElement(int[] nums, int val);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {381, 91, 93, 1, 3, 1, 73, 91};
        System.out.println(solution.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }
}
