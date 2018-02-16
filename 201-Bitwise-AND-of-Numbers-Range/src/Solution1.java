public class Solution1 extends Solution {
    /**
     * 当m & n进行运算时，只有奇数 & 奇数的结果最后一位是1，其余情形都是0
     * @param m
     * @param n
     * @return
     */
    @Override
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int factor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m * factor;
    }
}
