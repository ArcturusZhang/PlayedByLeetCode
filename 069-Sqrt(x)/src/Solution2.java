public class Solution2 {
    /**
     * 利用数列a_{n+1} = (a_n + x / a_n) / 2的极限为sqrt(x)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
