public class Solution1 extends Solution {
    /**
     * 利用求和
     * @param nums
     * @return
     */
    @Override
    public int missingNumber(int... nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
