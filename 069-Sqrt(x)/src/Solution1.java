public class Solution1 {
    /**
     * 直接利用循环判定平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x < 4) return 1;
        long i;
        long target = x;
        for (i = 2; i * i <= target; i++) ;
        return (int)i - 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.mySqrt(Integer.MAX_VALUE));
        System.out.println(solution1.mySqrt(19));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.mySqrt(Integer.MAX_VALUE));
        System.out.println(solution2.mySqrt(19));
    }
}
