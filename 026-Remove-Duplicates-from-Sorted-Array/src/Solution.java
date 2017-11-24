import java.util.Arrays;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/</url>
     * 本题十分简单。。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 1, 2, 3, 4, 4, 5, 5};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
