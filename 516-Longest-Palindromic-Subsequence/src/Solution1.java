public class Solution1 extends Solution {
    /**
     * 动态规划。
     * 记dp(i,j)为s[i,j]中最长的回文子序列长度，则显然有边界条件为dp(i,i)=1
     * 状态转移方程分两种情况：
     * 1. 当s[i]==s[j]时，dp(i,j)=dp(i+1,j-1) + 2
     * 2. 当s[i]!=s[j]时，dp(i,j)=Math.max(dp(i+1,j), dp(i,j-1))
     *
     * @param s
     * @return
     */
    @Override
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int k = 1; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
