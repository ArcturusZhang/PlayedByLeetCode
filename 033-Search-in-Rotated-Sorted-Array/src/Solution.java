public class Solution {
    /**
     * 这是二分查找的一种变形
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 1));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 2));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 4));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 5));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 6));
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 7));
    }
}
