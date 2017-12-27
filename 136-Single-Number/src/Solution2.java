public class Solution2 {
    /**
     * 利用异或运算。异或运算有这样的基本性质，a^a = 0, a^b = b^a, a^0 = a。
     * 将数组中的所有数字依次做异或运算，最后得到的结果就是单独的数字。
     * 根据异或的性质，可以将计算的各个数字交换次序，使得重复的数字相邻。重复的数字求异或得到的结果是0，而0^0=0，
     * 所以最后得到的结果就是0^单独的数字=单独的数字
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
