public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/missing-number/description/</url>
     * @param nums
     * @return
     */
    public abstract int missingNumber(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.missingNumber(1, 2, 3, 4, 5, 7, 8, 0));
    }
}
