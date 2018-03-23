public class Solution1 extends Solution {
    /**
     * 动态规划。
     * 首先计算数组中元素的和，由于元素都是整数，所以和不是偶数必然不可能划分为和相等的两部分
     * 用f(i,j)表示数组中[0,i)（含0不含i）的子数组中是否含有和为j的子集。
     * 边界条件为f(i,0) = true，即数组的任意部分都包含和为0的子集，只要一个元素都不选就可以了。
     * 状态转移方程为
     * f(i+1,j) = f(i,j) || f(i, j-nums[i])
     * 每当考虑一个新元素时，有两种情况，如果前面已经包含了和为j的子集，那么无需考虑当前元素，必然存在和为j的子集。
     * 如果前面不包含和为j的子集，那么如想获得和为j的子集必须包含当前元素，需要查看是否包含和为j - nums[i]的子集。(注：j只需要从nums[i]开始循环）
     * @param nums
     * @return
     */
    @Override
    public boolean canPartition(int... nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= sum; j++) {
                dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
            }
        }
        return dp[nums.length][sum];
    }
}
