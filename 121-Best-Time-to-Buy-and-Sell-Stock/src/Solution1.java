public class Solution1 extends Solution {
    @Override
    public int maxProfit(int... prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0], max = 0; // min记录至当前为止的最低价格，max记录当前能得到的最高收益
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
