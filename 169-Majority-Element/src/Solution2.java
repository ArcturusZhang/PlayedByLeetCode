import java.util.Arrays;

public class Solution2 extends Solution {
    /**
     * 解：
     * 利用排序。超过半数的元素在排序后的最坏情形就是它是最小（或最大）的元素，由于其个数超过了半数，所以必然是{@code nums[nums.length / 2]}。
     * @param nums
     * @return
     */
    @Override
    public int majorityElement(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
