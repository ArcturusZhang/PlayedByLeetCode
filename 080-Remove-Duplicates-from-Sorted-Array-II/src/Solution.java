import java.util.Arrays;

public class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 1, 1, 2, 2, 3, 4, 4, 4, 6, 6};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
