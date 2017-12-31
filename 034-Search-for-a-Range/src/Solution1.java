import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/search-for-a-range/description/</url>
     * 解：
     * 这里采用了一种特殊的二分查找，即查找不小于target的最小元素的索引（即search函数），如果所有的元素都比target小，返回nums.length，
     * 如果所有的元素都比target大，则返回0。利用这个函数，target出现范围的左端索引应该为start = search(nums, target)
     * 检验start为nums.length或者start处元素不等于target，则说明数组中没有target元素。
     * 如果数组中有这个元素，则右端索引可以通过查找不小于target+1元素的索引来得到。
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int start = search(nums, target);
        if (start == nums.length || nums[start] != target) return new int[] {-1, -1};
        return new int[] {start, search(nums, target + 1) - 1};
    }

    private int search(int[] nums, int target) {
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
