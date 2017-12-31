import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> threeSum(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{3,0,-2,-1,1,2}));
    }
}
