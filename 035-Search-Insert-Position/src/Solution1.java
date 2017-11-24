public class Solution1 {
    /**
     * 简单的遍历即可
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int pos = 0;
        while (pos < nums.length && nums[pos] < target) {
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        Class<?> clazz = Solution1.class;
    }
}
