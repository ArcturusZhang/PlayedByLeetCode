public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/majority-element/solution/</url>
     * @param nums
     * @return
     */
    public abstract int majorityElement(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.majorityElement(1, 2, 3, 1, 1, 7)); // 这个数组实际上不符合题目的设定，所以不同解法对这个情形可能给出不同的结果。
        System.out.println(solution.majorityElement(2, 2));
        System.out.println(solution.majorityElement(6, 5, 5));
    }
}
