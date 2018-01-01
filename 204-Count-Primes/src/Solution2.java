public class Solution2 extends Solution {
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
        boolean[] isNotPrime = new boolean[n];
        int count = n - 2;
        for (int i = 2; i < n; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i + i; j < n; j += i) {
                if (!isNotPrime[j]) {
                    isNotPrime[j] = true;
                    count--;
                }
            }
        }
        return count;
    }
}
