public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        // a.length() >= b.length()
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
