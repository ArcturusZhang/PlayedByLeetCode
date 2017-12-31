import java.util.Arrays;

public abstract class Solution {
    public abstract int[] plusOne(int[] digits);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(Arrays.toString(solution.plusOne(new int[] {5,2,9,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[] {9,9,9,9})));
    }
}
