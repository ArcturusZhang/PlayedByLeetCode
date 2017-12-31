public class Solution1 extends Solution {
    /**
     * 暴力穷举
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return null;
    }
}
