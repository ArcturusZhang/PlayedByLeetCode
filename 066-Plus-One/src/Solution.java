import java.util.Arrays;

public class Solution {
    /**
     * 解：简单的整数加法。由于是加一，仅有的会使位数增加的情形就是例如999+1=1000这种情况。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + carry;
            carry = digit / 10;
            digits[i] = digit % 10;
        }
        if (carry != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[] {5,2,9,9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[] {9,9,9,9})));
    }
}
