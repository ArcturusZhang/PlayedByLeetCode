public class Solution {
    /**
     * 题目描述：
     * 不使用乘法、除法和求余数运算，实现两个整数的除法。
     * 解：
     * 如果不考虑性能因素，先考虑将两个数字转化为long（防止溢出），然后不断地做除数减被除数运算直到得到负数为止，运算次数即为商。
     * 但这样会超时，在极端情形下，效率很低。
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 这种情形溢出
            return -dividend;
        }
        long ldividend = dividend;
        long ldivisor = divisor;
        // TODO!!!!!!!!!!!!!
    }

    private long ldivide(long ldividend, long ldivisor) {

    }

    public static void main(String[] args) {

    }
}
