public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/first-missing-positive/description/</url>
     * 解：
     * 桶排序。将每个数字放到其应该在的位置上。最后扫描一遍数组，第一个不在其应该在的位置上的数字即为所求。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    @Override
    public int firstMissingPositive(int... nums) {
        if (nums == null || nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] >= nums.length || nums[i] == i + 1) {
                i++; // 如果当前位置的数字是0或负数，直接跳过。如果当前位置数字已经在正确的位置上，也直接跳过
            } else if (nums[i] != nums[nums[i] - 1]) { // 注意：数组中可能有相同的数字，如果交换这样的两个数字会造成死循环！这里的判断避免了这种情况
                swap(nums, i, nums[i] - 1); // 当前位置没有在正确的位置上，将其与其应在位置处的数字交换位置
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
