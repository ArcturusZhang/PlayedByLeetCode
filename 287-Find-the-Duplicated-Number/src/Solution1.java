public class Solution1 extends Solution {
    /**
     * 暴力搜索
     * 时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    @Override
    public int findDuplicate(int[] nums) {
        for (int i = 1; i <= nums.length - 1; i++) {
            int count = 0;
            for (int num : nums) {
                if (i == num) count++;
            }
            if (count > 1) return i;
        }
        return -1;
    }
}
