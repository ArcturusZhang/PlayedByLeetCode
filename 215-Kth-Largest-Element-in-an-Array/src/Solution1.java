import java.util.Arrays;

public class Solution1 extends Solution {
    int length;

    /**
     * 直接利用堆排序来实现，建堆之后执行k次removeMax操作即可。为了方便将remove掉的max依次放在数组末尾
     * @param nums
     * @param k
     * @return
     */
    @Override
    public int findKthLargest(int[] nums, int k) {
        length = nums.length;
        buildHeap(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < k; i++) removeMax(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private void removeMax(int[] nums) {
        if (length == 0) return;
        swap(nums, 0, --length);
        siftDown(nums, 0);
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--)
            siftDown(nums, i);
    }

    private void siftDown(int[] nums, int index) {
        while (2 * index + 1 < length) {
            int child = 2 * index + 1;
            if (child + 1 < length && nums[child] < nums[child + 1]) child = child + 1;
            if (nums[index] >= nums[child]) break;
            swap(nums, index, child);
            index = child;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
