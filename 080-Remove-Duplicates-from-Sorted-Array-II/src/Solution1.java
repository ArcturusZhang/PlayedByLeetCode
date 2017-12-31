public class Solution1 extends Solution {
    /**
     * 与移除重复元素的做法类似
     *
     * @param nums
     * @return
     */
    @Override
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        int count = 1, last = nums[0], pos = 1, length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                count++;
                if (count <= 2) {
                    nums[pos] = nums[i];
                    pos++;
                    length++;
                }
            } else {
                count = 1;
                last = nums[i];
                nums[pos] = nums[i];
                pos++;
                length++;
            }
        }
        return length;
    }
}
