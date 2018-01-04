import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/longest-consecutive-sequence/description/</url>
     * 解：
     * 排序。先将数组排序，这有O(N log(N))的时间复杂度。然后从头开始扫描，维护一个记录最大长度和当前长度的变量，扫描一次即可得到结果。
     * @param nums
     * @return
     */
    @Override
    public int longestConsecutive(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int longest = 1, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 1;
            }
        }
        return longest;
    }
}
