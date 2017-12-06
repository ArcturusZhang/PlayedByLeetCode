public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/edit-distance/description/</url>
     * 解：
     * 动态规划。记dp(i,j)为从word1[0,i)到word2[0,j)的最短编辑距离，不包括索引为i和j的字母（左闭右开）。
     * 比较word1[i-1]和word2[j-1]是否相同。
     * 1. 如果{@code word1[i-1] == word2[j-1]}，则dp(i,j) = dp(i-1,j-1)
     * 2. 如果{@code word1[i-1] != word2[j-1]}，则有三种情况从这一部分的word1转化到这一部分的word2：
     *    a. 将word1[i-1]替换为word2[j-1]，此时dp(i,j) = dp(i-1,j-1) + 1
     *    b. 在word1[i-1]后面插入word2[j-1]，此时dp(i,j) = dp(i,j-1) + 1
     *    c. 删除word1[i-1]，此时dp(i,j) = dp(i-1,j) + 1
     * 所以状态转移方程为
     * 当{@code word1[i-1] == word2[j-1]}时，dp(i,j) = dp(i-1,j-1)
     * 当{@code word1[i-1] != word2[j-1]}时，dp(i,j) = min(dp(i-1,j-1), dp(i-1,j), dp(i,j-1)) + 1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.equals(word2)) return 0;
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 第一行
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }
        // 第一列
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        // 其余区域
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("main", "male"));
        System.out.println(solution.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}
