public class Solution1 extends Solution {
    @Override
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        if (n == 1) return;
        if (k == 0) return;
        if (k < 0) {
            rotate(nums, n + k);
            return;
        }
        if (k >= n) {
            rotate(nums, k % n);
            return;
        }
        int[] fliped = new int[k];
        for (int i = 0; i < k; i++) {
            fliped[i] = nums[n - k + i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = fliped[i];
        }
    }
}
