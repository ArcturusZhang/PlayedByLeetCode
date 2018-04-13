import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 extends Solution {
    /**
     * 动态规划。
     * 记dp(i)为子串s[0,i)（左开右闭）是否能用字典中单词构成。则显然dp(0) = true
     * 状态转移方程则为
     * dp(i) = dp(j) && dict.contains(substring(j, i))
     * 对所有的j < i，只需要有1个j能使得上式为true即可有dp(i)= true
     * @param s
     * @param wordDict
     * @return
     */
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 计算dp[i]
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                String word = s.substring(j, i);
                if (dict.contains(word)) dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
