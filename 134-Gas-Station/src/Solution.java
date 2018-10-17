public abstract class Solution {
    public abstract int canCompleteCircuit(int[] gas, int[] cost);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
