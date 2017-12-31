public class Solution1 extends Solution {
    /**
     * 解：
     * 分治。每次将指数折半。即
     * 当n是偶数时，Pow(x, n) = Pow(x * x, n / 2)
     * 当n时奇数时，Pow(x, n) = x * Pow(x * x, n / 2)
     * 特别地，当n为负数时，只需要取Pow(x, n) = Pow(1 / x, -n)即可。
     * 对n取相反数可能会溢出（{@code Integer.MIN_VALUE}），一旦溢出会导致死循环，因为{@code Integer.MIN_VALUE}的相反数是他自身。
     * @param x
     * @param n
     * @return
     */
    @Override
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++;
                n = -n;
                x = 1 / x;
                return x * x * myPow(x * x, n / 2);
            }
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
