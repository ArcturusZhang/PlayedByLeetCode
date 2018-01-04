public abstract class Solution {
    public abstract int longestConsecutive(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.longestConsecutive(0, 0));
        System.out.println(solution.longestConsecutive(100, 4, 200, 1, 3, 2));
        System.out.println(solution.longestConsecutive(9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6));
    }
}
