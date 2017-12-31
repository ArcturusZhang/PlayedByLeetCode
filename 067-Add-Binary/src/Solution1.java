public class Solution1 extends Solution {
    /**
     * 字符串加法的二进制版本。和十进制的没有什么差别。
     * @param a
     * @param b
     * @return
     */
    @Override
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int digit;
            if (j >= 0) {
                digit = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            } else {
                digit = a.charAt(i) - '0' + carry;
            }
            carry = digit / 2;
            digit %= 2;
            sb.append(digit);
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
