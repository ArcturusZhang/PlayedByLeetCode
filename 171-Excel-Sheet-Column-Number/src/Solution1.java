public class Solution1 extends Solution {
    /**
     * 这类似于26进制数
     * @param s
     * @return
     */
    @Override
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'A';
            result = result * 26 + digit + 1;
        }
        return result;
    }
}
