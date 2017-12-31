import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/next-permutation/description/</url>
     * 解：
     * 从数组的最右端开始向左寻找递增部分（向左递增）结束位置的索引，例如1,3,2,4，向左递增结束位置的索引为3，即最后一个元素；
     * 1,3,4,2，向左递增结束为止的索引为2，因为其中4,2为一个向左递增的部分。
     * 1,2,4,3，向左递增结束为止的索引为2，因为其中4,3为一个向左递增的部分。
     * 然后根据这个位置pos，有三种情况：
     * 1. pos == 0，说明整个序列是向左递增的，应该将整个数组翻转；
     * 2. pos == n - 1，说明这个序列末尾没有向左递增的序列，这时只需要将最后两个元素交换即可；
     * 3. 其他情形，这时，需要找出这个向左递增序列中【比pos-1元素大的最小元素】，将这个元素的索引记作minmax，交换pos-1元素与minmax元素，
     *    然后将pos至数组末尾的部分翻转。
     *    例如1,3,4,2，它的下一个排列为1,4,2,3，操作步骤即为，寻找4,2中【比3大的最小元素】，即为4，将他们交换得到1,4,3,2，然后将末尾部分翻转
     *    得到1,4,2,3即为下一个排列。
     *    再例如1,2,4,3，它的下一个排列为1,3,2,4，操作步骤即为，寻找4,3中【比2大的最小元素】，即为3，将他们交换得到1,3,4,2，然后将末尾部分
     *    翻转得到1,3,2,4即为下一个排列。
     * @param nums
     */
    @Override
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int pos = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i;
                break;
            }
        }
        if (pos == 0) {
            reverse(nums, 0, n - 1);
        } else if (pos == n - 1) {
            reverse(nums, n - 2, n - 1);
        } else {
            // 找到pos及右端中比nums[pos - 1]大的数字中最小的那个
            int tmp = nums[pos - 1];
            int minmax = pos + 1;
            for (; minmax < n; minmax++) {
                if (nums[minmax] <= nums[pos - 1]) break;
            }
            minmax--;
            nums[pos - 1] = nums[minmax];
            nums[minmax] = tmp;
            reverse(nums, pos, n - 1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
