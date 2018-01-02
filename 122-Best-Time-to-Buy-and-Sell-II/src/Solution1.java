public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/</url>
     * 解：<url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/</url>
     * 官方解答有图表，更清楚
     * @param prices
     * @return
     */
    @Override
    public int maxProfit(int... prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min, max = 0;
        int i = 0;
        while (i < prices.length - 1) {
            // 寻找第一个坑
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            min = prices[i];
            // 寻找坑后的第一个峰
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            max += prices[i] - min;
        }
        return max;
    }
}
