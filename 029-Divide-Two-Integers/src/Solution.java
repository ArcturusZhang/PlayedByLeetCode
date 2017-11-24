public class Solution {
    /**
     * 题目描述：
     * 不使用乘法、除法和求余数运算，实现两个整数的除法。
     * 解：
     * 如果不考虑性能因素，先考虑将两个数字转化为long（防止溢出），然后不断地做除数减被除数运算直到得到负数为止，运算次数即为商。
     * 但这样会超时，在极端情形下，效率很低。所以这里核心函数采用了每次将除数加倍的方式来处理。
     * 注：这种每次将除数加倍的方法实际上就是二进制的长除法
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend == 0 || ldividend < ldivisor) return 0;
        long lans = ldivide(ldividend, ldivisor);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int)lans;
            if (sign < 0) ans = -ans;
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiply = 1;
        while (sum + sum <= ldividend) {
            sum += sum;
            multiply += multiply;
        }
        return multiply + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(2, 5));
        System.out.println(solution.divide(Integer.MIN_VALUE, 1));
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
        System.out.println(solution.divide(Integer.MIN_VALUE, -2));
    }
}
