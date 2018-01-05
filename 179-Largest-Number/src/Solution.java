public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/largest-number/description/</url>
     * @param nums
     * @return
     */
    public abstract String largestNumber(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.largestNumber(3, 30, 34, 5, 9));
        System.out.println(solution.largestNumber(0, 1));
        System.out.println(solution.largestNumber(0, 0));
    }
}
