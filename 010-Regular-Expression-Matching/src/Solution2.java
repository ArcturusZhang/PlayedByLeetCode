public class Solution2 extends Solution {
    /**
     * 动态规划
     * 记dp[i][j]为s[0,i)到p[0,j)的匹配情况
     * 当s[i - 1] == p[j - 1]或者p[j - 1] = '.'时，匹配一个字母，dp[i][j] = dp[i - 1][j - 1]
     * 当p[j - 1] == '*'时，有几种情况需要考虑
     * 1. s[i - 1] != p[j - 2]而且p[j - 2] != '.'，这时a*没有匹配，直接无视这组，dp[i][j] = dp[i][j - 2]
     * 2. s[i - 1] == p[j - 2]或者p[j - 2] == '.'，这时构成匹配，又有几种情况
     *    a. 构成多组匹配 dp[i][j] = dp[i - 1][j] 即再去考虑是否能与s[i]前的部分匹配
     *    b. 构成一组匹配 dp[i][j] = dp[i][j - 1]
     *    c. 即便匹配也无视掉 dp[i][j] = dp[i][j - 2]
     * @param s
     * @param p
     * @return
     */
    @Override
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && (j < 2 || dp[0][j - 2]);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
