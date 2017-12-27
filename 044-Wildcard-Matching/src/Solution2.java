public class Solution2 {
    /**
     * 用动态规划来求解。定义dp(i,j)为字符串string[0,i)和模式pattern[0,j)是否匹配。（区间是左开右闭的，这意味着string[0,0)表示空字符串）
     * 首先确定边界条件。dp(0,0) = true：两个空字符串是一定能够匹配的。
     * dp(i,0) = false：模式是空的，但字符串非空，这样一定是不能匹配的。
     * dp(0,j+1) = dp(0,j) && (pattern[j] == '*')：字符串是空的，但模式非空，这样如果能够匹配的话，模式中所以已考虑的字符必须都是*
     * 下面考虑状态转移方程，即求dp(i+1,j+1)。首先这需要根据pattern[j]的字符分为三种情况。
     * 第一种情况比较简单，pattern[j]是一个普通字符，不是?也不是*，这时pattern[j]和string[i]必须相等，否则不可能匹配
     * dp(i+1,j+1) = dp(i,j) && (string[i] == pattern[j])
     * 第二种情况也比较简单，pattern[j] == '?'，这时只要string还没到末尾（这是一定的）一定是能够匹配的。所以
     * dp(i+1,j+1) = dp(i,j)
     * 第三种情况就是pattern[j] == '*'的情况。这时可能是无视掉pattern中的这个星号，其余部分就可以匹配，这时有dp(i+1,j+1) = dp(i+1,j)
     * 也可能是星号只匹配了string[i]这个字符，这时有dp(i+1,j+1) = dp(i,j)
     * 还可能是string[i]并入前一个字符作为整体与当前的*匹配，这时有dp(i+1,j+1) = dp(i,j+1)
     * 所以，当pattern == '*'时，dp(i+1,j+1) = dp(i,j) || dp(i+1,j) || dp(i,j+1)
     * @param string
     * @param pattern
     * @return
     */
    public boolean isMatch(String string, String pattern) {
        if (string == null || pattern == null) return false;
        boolean[][] dp = new boolean[string.length() + 1][pattern.length() + 1];
        // 边界条件
        dp[0][0] = true;
        for (int j = 0; j < pattern.length(); j++) {
            dp[0][j + 1] = dp[0][j] && (pattern.charAt(j) == '*');
        }
        for (int i = 0; i < string.length(); i++) {
            dp[i + 1][0] = false;
        }
        // 填充内部元素
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pattern.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j] && (string.charAt(i) == pattern.charAt(j));
                }
            }
        }
        return dp[string.length()][pattern.length()];
    }
}
