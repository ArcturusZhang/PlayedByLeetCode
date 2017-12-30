public class Solution2 extends Solution {
    /**
     * 解：（Accepted）
     * 动态规划。定义dp[i]为字符串中从0到i这一部分（包括i）所能解码方式的数目。则边界条件为
     * dp[0] = 0, {@code if (s.charAt(0) == '0')}
     * dp[0] = 1, {@code if (s.charAt(0) != '0')}
     * 0到i的解码方式可以通过0到i-1的方式（对应当前位置取1位数字的情况）和0到i-2的方式（对应当前位置取2位数字的情况）
     * 所以状态转移方程为
     * dp[i] = (0 或 dp[i - 1]) + (0 或 1 或 dp[i - 2])
     * 第一个括号的取值条件为：当前字符为'0'时，取0；当前字符非零时，取dp[i-1]
     * 第二个括号的取值条件为：当i-1处字符非零，而且i-1和i字符构成的数字在1到26之间时，取dp[i - 2]或1（i-2越界时取1，这对应字符串为10或20开头）；
     *                    其他情形都取0
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)——可以优化，因为每一步的递推都只用到i-1和i-2的状态，所以可以只用3个变量储存所有的状态
     * @param s
     * @return
     */
    @Override
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i) != '0') dp[i] += dp[i - 1];
            int two;
            if (i - 1 >= 0 && s.charAt(i - 1) != '0' && (two = Integer.valueOf(s.substring(i - 1, i + 1))) > 0 && two <= 26) {
                dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
            }
        }
        return dp[s.length() - 1];
    }
}
