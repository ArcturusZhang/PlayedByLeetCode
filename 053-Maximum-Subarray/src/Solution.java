public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/maximum-subarray/description/</url>
     * 解：
     * 动态规划。记f[i]为以nums[i]为结尾的所有子序列中最大的和。则有状态转移方程为
     * f[i] = max(f[i-1] + nums[i], nums[i])
     * nums[i]这个数字必然在最大子序列中，所以如果前一个元素的最大子序列和为负，那么完全可以舍弃掉，从nums[i]重新开始。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int fi = nums[0];
        for (int i = 1; i < nums.length; i++) {
            fi = Math.max(fi + nums[i], nums[i]);
            if (fi > max) max = fi;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
