public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/wildcard-matching/description/</url>
     * 解：
     * 本题用了两种方法来实现。Solution1是我最初写的暴力求解，有O(2^(N+M))的复杂度，Time limit exceeded
     * Solution2则是用了动态规划，时间复杂度是O(MN)，空间复杂度也是O(MN)，具体请见Solution2的注释
     * @param string
     * @param pattern
     * @return
     */
    @Override
    public boolean isMatch(String string, String pattern) {
        if (string == null || pattern == null) return false;
        return isMatchCore(string, 0, pattern, 0);
    }

    private boolean isMatchCore(String string, int s, String pattern, int p) {
        if (s > string.length()) return false;
        if (s == string.length() && p == pattern.length()) return true; // 都到了末尾，匹配成功
        if (p == pattern.length() && s < string.length()) return false; // pattern到了末尾，但string还没有遍历完成，匹配失败
        if (pattern.charAt(p) == '?') { // 处理?
            return isMatchCore(string, s + 1, pattern, p + 1); // ?匹配任意单个字符
        } else if (pattern.charAt(p) == '*') { // 处理*
            boolean result;
            for (int i = s; i <= string.length(); i++) {
                result = isMatchCore(string, i, pattern, p + 1);
                if (result) return true;
            }
            return false;
        } else {
            if (s >= string.length()) return false;
            if (pattern.charAt(p) != string.charAt(s)) return false; // 当前字母不相同，匹配失败
            return isMatchCore(string, s + 1, pattern, p + 1); // 如果当前字母相同，则继续查看下一字符
        }
    }
}
