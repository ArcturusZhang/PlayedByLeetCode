public abstract class Solution {
    public abstract boolean canPartition(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.canPartition(1, 5, 11, 5));
        System.out.println(solution.canPartition(1, 2, 3, 5));
    }
}
