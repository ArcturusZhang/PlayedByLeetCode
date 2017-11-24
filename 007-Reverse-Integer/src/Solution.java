public class Solution {
    /**
     * 翻转一个整数。如果结果溢出，返回0
     * 这里用了{@code long}，算是投机取巧了。如果不使用long，可以用{@code newResult = result * 10 + num % 10}，然后判断
     * {@code (newResult - num % 10) == result}是否成立，如果不成立则说明溢出了。
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) return x;
        int sign = x > 0 ? 1 : -1;
        long num = sign * x;
        long result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        result *= sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(321));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(1534236469));
    }
}
