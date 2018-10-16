public class Solution1 extends Solution {
    @Override
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        long[] dp = new long[s.length() + 1];
        // initial condition
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);
            if (second == '*') dp[i] += 9 * dp[i - 1];
            else if (second > '0') dp[i] += dp[i - 1];
            if (first == '*') {
                if (second == '*') dp[i] += 15 * dp[i - 2];
                else if (second <= '6') dp[i] += 2 * dp[i - 2];
                else dp[i] += dp[i - 2];
            } else if (first == '1' || first == '2') {
                if (second == '*') {
                    if (first == '1') dp[i] += 9 * dp[i - 2];
                    else dp[i] += 6 * dp[i - 2];
                } else {
                    int num = (first - '0') * 10 + (second - '0');
                    if (num <= 26) dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[s.length()];
    }
}
