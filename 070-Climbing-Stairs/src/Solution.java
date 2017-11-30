public class Solution {
    /**
     * 解：
     * 动态规划。记f(i)为走到第i阶的走法总数，则
     * f(1) = 1;
     * f(2) = 2;
     * f(n) = f(n-1) + f(n-2)
     * 实际上解就是斐波那契数列。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(10));
    }
}
