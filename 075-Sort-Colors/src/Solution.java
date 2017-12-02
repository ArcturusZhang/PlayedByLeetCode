public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int countZeroes = 0, countOnes = 0, countTwos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZeroes++;
            if (nums[i] == 1) countOnes++;
            if (nums[i] == 2) countTwos++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < countZeroes) nums[i] = 0;
            else if (i < countZeroes + countOnes) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
