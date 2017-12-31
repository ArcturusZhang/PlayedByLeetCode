public abstract class Solution {
    public abstract int threeSumClosest(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
