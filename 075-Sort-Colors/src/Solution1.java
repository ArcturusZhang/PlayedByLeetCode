public class Solution1 extends Solution {
    /**
     * 十分简单的题目，先遍历一次统计数量，然后再遍历一次应用更改。这应该可以算作桶排序。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)——只用了三个变量
     * @param nums
     */
    @Override
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
