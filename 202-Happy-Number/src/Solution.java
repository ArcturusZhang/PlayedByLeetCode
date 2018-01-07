public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/happy-number/description/</url>
     * @param n
     * @return
     */
    public abstract boolean isHappy(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(200));
    }
}
