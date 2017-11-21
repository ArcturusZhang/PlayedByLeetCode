public class Solution {
    /**
     *
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
