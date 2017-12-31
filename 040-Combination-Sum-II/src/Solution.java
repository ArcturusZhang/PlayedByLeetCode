import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> combinationSum2(int[] candidates, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {2, 3, 6, 7};
        System.out.println(solution.combinationSum2(nums, 6));
        System.out.println(solution.combinationSum2(nums, 7));
        System.out.println(solution.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }
}
