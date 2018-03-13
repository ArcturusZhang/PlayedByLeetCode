public class Solution2 extends Solution {
    /**
     * 分治法。
     * 将1到n的数字分为[low, mid]和[mid + 1, high]两部分，遍历数组，计数其中不超过mid的数字数量。
     * 如果数量 <= mid，则说明重复数字在[mid+1, high]区间内；如果数量 > mid，则说明重复数字出现在[low, mid]区间内。重复这个过程直到区间长度为1
     * 重复的数字即为当时的low（事实上也等于mid和high）
     * 时间复杂度：O(N * log(N))
     * @param nums
     * @return
     */
    @Override
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
