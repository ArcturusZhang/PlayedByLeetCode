public class Solution1 extends Solution {
    /**
     * 直接逐字符判断。没有*时，算法是很简单的，逐字查看是否相同（如果为.则视为相同）。
     * 当有*时，则需要判断当前字符的下一个字符是否为*，如果为*则需要特殊处理。(字符*)表达式可以匹配字符任意次（包括0次），所以有两种情况：
     * 第一种情况，直接无视掉这个*表达式（对应0次的情况）
     * 第二种情况，将这个*表达式的字符匹配一次，并保留这个*表达式。（递归执行，即可实现匹配任意次）
     * @param s
     * @param p
     * @return
     */
    @Override
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0) return s.length() == 0;
        if (p.charAt(0) == '*') return false;
        return matchCore(s, 0, p, 0);
    }

    private boolean matchCore(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return matchCore(s, i, p, j + 2) // 无视掉这个*表达式
                    || (firstMatch && matchCore(s, i + 1, p, j)); // 或者匹配*前面的字符一次，保留*表达式
            } else {
                return firstMatch && matchCore(s, i + 1, p, j + 1); // 没有星星表达式则继续前进一个字符
            }
        }
    }
}
