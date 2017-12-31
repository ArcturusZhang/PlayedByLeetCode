import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> combinationSum(int[] candidates, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {2, 3, 6, 7};
        System.out.println(solution.combinationSum(nums, 6));
        System.out.println(solution.combinationSum(nums, 7));
    }
}
