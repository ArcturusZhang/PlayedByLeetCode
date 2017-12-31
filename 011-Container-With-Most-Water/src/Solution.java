public abstract class Solution {
    public abstract int maxArea(int[] height);

    public static void main(String[] args) {
       testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.maxArea(new int[] {3, 2, 5, 6, 4, 1}));
    }
}
