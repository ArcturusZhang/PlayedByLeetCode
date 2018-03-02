public class Solution1 extends Solution {
    /**
     * 动态规划。
     * 记f(i,j,k)表示s1[i,i+k)是否为s2[j,j+k)的Scramble。为了得到f(i,j,k)的值，需要考虑s1所有可能的分割得到的子串是否分别为s2相应分割所得
     * 子串Scramble。即对1 <= q < k考虑将s1分割为s1[i,i+q)和s1[i+q,i+k)，相应的s2有两种分割方式
     * s2[j,j+q), s2[j+q,j+k)和s2[j,j+k-q), s2[j+k-q,j+k)
     * 所以
     * f(i,j,k) = (f(i,j,q) && f(i+q,j+q,k-q)) || (f(i,j+k-q,q) && f(i+q,j,k-q))
     * 这个过程不需要每次都遍历所有可能的q，只要其中一个q使得f(i,j,k)为true，就可以停止进入下一次循环中。
     * @param s1
     * @param s2
     * @return
     */
    @Override
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int length = s1.length();
        boolean[][][] f = new boolean[length][length][length + 1];
        for (int k = 1; k <= length; k++) {
            for (int i = 0; i + k <= length; i++) {
                for (int j = 0; j + k <= length; j++) {
                    if (k == 1) {
                        f[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int q = 1; q < k && !f[i][j][k]; q++) { // 只要对某个q使得Scramble成立了之后就没必要再继续做下去
                            f[i][j][k] = (f[i][j][q] && f[i + q][j + q][k - q])
                                    || (f[i][j + k - q][q] && f[i + q][j][k - q]);
                        }
                    }
                }
            }
        }
        return f[0][0][length];
    }
}
