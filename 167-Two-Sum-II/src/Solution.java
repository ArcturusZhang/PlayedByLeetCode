import java.util.Arrays;

public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/</url>
     * @param numbers
     * @param target
     * @return
     */
    public abstract int[] twoSum(int[] numbers, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}
