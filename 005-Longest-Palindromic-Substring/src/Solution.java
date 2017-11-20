public class Solution {
    /**
     * 题目描述：
     * Given a string s, find the longest palindromic substring in s.
     * 解：
     * 利用动态规划，定义dp(i,j)为从i到j的子串（包含i和j）是否为回文，则边界条件为：
     * 1. dp(i,i) = true;
     * 2. dp(i,i+1) = 如果i字符和i+1字符相同为true，否则为false
     * 状态转移方程则为
     *    dp(i,j) = dp(i+1, j-1) && (s[i] == s[j])
     * 即如果i+1到j-1不是回文，则i到j必然不是；如果i+1到j-1是回文，则需要i字符和j字符相等，i到j才是回文。
     * 据此关系可以得到状态表格，再从表格右上角(0,n-1)处开始逐个查看，查到第一个为true的dp(i, j)，即可返回
     * <@code>s.substring(i, j + 1)</@code>
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() < 2) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        dp[n - 1][n - 1] = true;
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                dp[i][i + k] = dp[i + 1][i + k - 1] && (s.charAt(i) == s.charAt(i + k));
            }
        }
        for (int k = n - 1; k >= 0; k--) {
            for (int i = 0; i < n - k; i++) {
                if (dp[i][i + k]) return s.substring(i, i + k + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome(""));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("polamc"));
        System.out.println(new Solution().longestPalindrome("ab"));
        System.out.println(new Solution().longestPalindrome("aa"));
    }
}
