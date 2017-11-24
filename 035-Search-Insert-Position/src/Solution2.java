public class Solution2 {
    /**
     * 这里利用034中的特殊二分查找：查找不小于target的元素。如果该元素与target相等，那么就是target元素的索引，
     * 如果不相等，那么就是大于target的元素中最小的（也说明数组中没有target），即为target应该插入的位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
