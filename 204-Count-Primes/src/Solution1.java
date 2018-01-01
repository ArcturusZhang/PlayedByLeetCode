import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 题目描述：求小于n的所有质数的个数
     * 解：
     * 筛法。
     * @param n
     * @return
     */
    @Override
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int[] nums = new int[n - 1];
        int count = n - 2;
        for (int i = 1; i < n - 1; i++) {
            nums[i] = i + 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + nums[i]; j < n - 1; j += nums[i]) {
                if (nums[j] != 0) {
                    nums[j] = 0;
                    count--;
                }
            }
        }
        return count;
    }
}
