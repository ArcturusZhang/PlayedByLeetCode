public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/</url>
     * 本题十分简单。。
     *
     * @param nums
     * @return
     */
    @Override
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }
}
