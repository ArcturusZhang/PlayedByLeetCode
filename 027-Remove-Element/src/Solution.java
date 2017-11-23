public class Solution {
    /**
     * 题目描述：在nums数组中删除所有等于val的元素，并返回删除后的数组实际长度
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        if (nums.length == 0) return nums.length;
        int newLength = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[--newLength];
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 1));
    }
}
