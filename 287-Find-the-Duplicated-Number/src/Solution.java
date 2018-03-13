public abstract class Solution {
    public abstract int findDuplicate(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.findDuplicate(new int[] {1, 2, 3, 4, 5, 5, 6, 5, 7, 5}));
    }
}
