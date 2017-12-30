public class Solution1 extends Solution {
    /**
     * 直接利用循环判定平方根
     * @param x
     * @return
     */
    @Override
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x < 4) return 1;
        long i;
        long target = x;
        for (i = 2; i * i <= target; i++) ;
        return (int)i - 1;
    }
}
