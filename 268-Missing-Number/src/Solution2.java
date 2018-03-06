public class Solution2 extends Solution {
    /**
     * 利用异或。数组中数字是0到n，但缺少了一个，而数组中每个数字的索引是0到n-1，在索引上补充一个n，那么这两组数字中每个数字都出现了两次，
     * 唯独缺少的那个数字只出现了一次，所以将他们全部异或起来，得到的结果就是缺少的数字
     * @param nums
     * @return
     */
    @Override
    public int missingNumber(int... nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }
}
