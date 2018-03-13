public class Solution1 extends Solution {
    /**
     * 由于10=2*5，所以确定末尾的0的个数只需要知道从1到n的所有数字中因数2和因数5的个数，n!末尾0的个数等于其中较小的。
     * 由于因数2的个数显然比因数5多得多，所以只需考虑因数5的个数即可。
     * 基于这样一个事实，从1到n的所有数字中，5的倍数的个数=n / 5（整数除法）
     * 但不只是5的倍数中含有因数5，25的倍数中同样含有因数5，而25的倍数个数=n / 25
     * 以此类推，从1到n的所有整数中，因数5的个数=n / 5 + n / 25 + n / 125 + ...
     * 从这个式子就可以看出因数5的个数比因数2少（将上面式子中的5都换成2即为2的个数）
     *
     * 需要注意的是，直接利用循环实现上面的式子会有溢出的问题，当n比较大的时候，在最后一次循环结束之后，还需要做一次m *= 5，并判断m <= n
     * 这个时候m可能已经溢出为负数，所以循环不会结束，而是又进行了一次，直到不会溢出为止。这样得到的结果显然是错误的。
     *
     * @see Solution1#trailingZeroesWrong(int)
     * @param n
     * @return
     */
    @Override
    public int trailingZeroes(int n) {
        int zeroes = 0;
        while (n > 0) {
            zeroes += n / 5;
            n /= 5;
        }
        return zeroes;
    }

    public int trailingZeroesWrong(int n) {
        int zeroes = 0;
        for (int m = 5; m <= n; m *= 5) {
            zeroes += n / m;
        }
        return zeroes;
    }
}
