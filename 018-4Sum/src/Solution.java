import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> fourSum(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }
}
