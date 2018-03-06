public class Solution1 extends Solution {
    /**
     * 是2的幂的数字只有1位为1，因此不断地将n右移检查是否只有1位为1即可。
     * @param n
     * @return
     */
    @Override
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            int bit = n & 1;
            if (bit != 0) return false;
            n >>= 1;
        }
        return true;
    }
}
