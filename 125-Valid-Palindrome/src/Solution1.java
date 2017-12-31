public class Solution1 extends Solution {
    /**
     * 题目描述：判断一个字符串是否为回文。忽略所有非字母和数字的字符，不计大小写。
     * 解：
     * 本题很简单，从两端同时向中间推进
     * @param s
     * @return
     */
    @Override
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (!isDigit(s.charAt(left)) && !isChar(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isDigit(s.charAt(right)) && !isChar(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }
}
