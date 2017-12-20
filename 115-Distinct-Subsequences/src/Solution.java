import java.util.Arrays;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/distinct-subsequences/description/</url>
     * 解：
     * 利用动态规划。记dp(i,j)为字符串S[0,j)中含有子串T[0,i)的次数（其中字符串中不包含索引为i和j的字符）
     * 边界条件：
     * dp(0,j) = 1，当i=0时，子串T[0,0)为空，所以只有一种方式。
     * dp(i,0) = 0，当j=0时，字符串S[0,0)为空，不论T为什么，都不存在这样的方式
     * 转移方程：求dp(i+1,j+1)。（注意dp(i+1,j+1)中所指的S和T中都是不包含索引为i+1和j+1的字母的。）
     * 当S[j]!=T[i]时，dp[i+1][j+1] = dp[i+1][j]，由于最后字母不相同，所以增加一个字母不会增加包含方式
     * 当S[j]==T[i]时，dp[i+1][j+1] = dp[i][j] + dp[i+1][j]。
     *                    dp[i][j]理解为S和T都减少一个字母的包含方式（由于最后一个字母相同，所以这个字母不影响结果）
     *                    dp[i+1][j]理解为S不包含最后一个字母的情形，与S[j+1]!=T[i+1]的情形相同。
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
    }
}
