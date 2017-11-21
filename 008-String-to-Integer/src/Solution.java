public class Solution {
    /**
     * 题目描述：
     * Implement atoi to convert a string to an integer.
     * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
     * yourself what are the possible input cases.
     * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible
     * to gather all the input requirements up front.
     * 解：
     * 需要在一个字符串前端尽可能读取一个数字。第一步先要去掉开头的空白字符。
     * 第二步确定符号。然后可以依次读入数字。最后返回读入的数字，直到读取第一个不是数字的字符为止。
     * 溢出的情形：要在进行这步的计算之前进行，如果前面的结果已经大于<@code>Integer.MAX_VALUE / 10</@code>
     * （这个数字与<@code>Integer.MIN_VALUE / 10</@code>是相等的），或者前面的结果等于<@code>Integerl.MAX_VALUE</@code>，
     * 而且当前位数字大于7（正数）或者大于8（负数），则说明结果必然会溢出。
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 1) {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') return str.charAt(0) - '0';
            else return 0;
        }
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') start = 1;
        if (str.charAt(0) == '-') sign = -1;
        int result = 0;
        int pos = start;
        while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
            char c = str.charAt(pos);
            int digit = c - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            pos++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-0"));
        System.out.println(new Solution().myAtoi("0"));
        System.out.println(new Solution().myAtoi("+0"));
        System.out.println(new Solution().myAtoi("-1e3"));
        System.out.println(new Solution().myAtoi("241"));
        System.out.println(new Solution().myAtoi("-31094"));
        System.out.println(new Solution().myAtoi("-99999999999977"));
        System.out.println(new Solution().myAtoi("+99999999999999"));
        System.out.println(new Solution().myAtoi("99999999999999"));
        System.out.println(new Solution().myAtoi("99999s99999"));
        System.out.println(new Solution().myAtoi("2147483647"));
        System.out.println(new Solution().myAtoi("2147483648"));
        System.out.println(new Solution().myAtoi("-2147483647"));
        System.out.println(new Solution().myAtoi("-2147483648"));
        System.out.println(new Solution().myAtoi("-2147483649"));
    }
}
