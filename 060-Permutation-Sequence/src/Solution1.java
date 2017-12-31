public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/permutation-sequence/description/</url>
     * 解：
     * 直接利用第031题中的获得下一排列的方法，反复调用即可。
     * @param n
     * @param k
     * @return
     */
    @Override
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        if (k == 1) return arrayToString(nums);
        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        return arrayToString(nums);
    }

    private void nextPermutation(int[] nums) {
        // 寻找倒序位置
        int pos = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i;
                break;
            }
        }
        if (pos == 0) {
            reverse(nums, 0, nums.length - 1);
        } else if (pos == nums.length - 1) {
            reverse(nums, nums.length - 2, nums.length - 1);
        } else {
            int idx = pos + 1;
            for (;idx < nums.length; idx++) {
                if (nums[idx] < nums[pos - 1]) break;
            }
            idx--;
            // 交换pos-1和idx
            int tmp = nums[idx];
            nums[idx] = nums[pos - 1];
            nums[pos - 1] = tmp;
            reverse(nums, pos, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
