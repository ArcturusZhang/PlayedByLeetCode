import java.util.Arrays;

public class Solution {
    /**
     * 题目描述：<@url>https://leetcode.com/problems/3sum-closest/description/</@url>
     * 解：
     * 与3Sum类似的方法，只不过是再额外维护一个记录最小差别和最接近的和的变量即可
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE; // 维护实际和与target之间的差
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp == target) return target;
                if (Math.abs(tmp - target) < gap) {
                    gap = Math.abs(tmp - target);
                    sum = tmp;
                } // 维护最小值
                if (tmp < target) j++;
                else k--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
