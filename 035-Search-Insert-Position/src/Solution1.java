public class Solution1 extends Solution {
    /**
     * 简单的遍历即可
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int searchInsert(int[] nums, int target) {
        int pos = 0;
        while (pos < nums.length && nums[pos] < target) {
            pos++;
        }
        return pos;
    }
}
