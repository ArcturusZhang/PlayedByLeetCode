public class Solution1 extends Solution {
    /**
     * 动态规划
     * 记G(n)为从1到n的n个整数所能构造的所有不同二叉搜索树的数量。
     * 记F(i,n)为从1到n的n个整数所能构造的以i为根的所有不同二叉搜索树的数量。
     * 那么显然应该有
     * G(n) = F(1,n) + F(2,n) + ... + F(n,n)
     * 构造一个二叉搜索树应该按照如下方式递归进行：
     * 1. 选择一个数字i作为根
     * 2. 将根数字左端的所有数字1至i-1构造成一个二叉搜索树作为i的左孩子
     * 3. 将根数字右端的所有数字i+1至n狗造成一个二叉搜索树作为i的右孩子
     * 如此构造出的二叉搜索树必然是互不相同的，因为他们都有不同的根元素。
     * 所以F(i,n) = 1至i-1构造树的数量 * i+1至n构造树的数量 = G(i-1) * G(n-i)
     * 即有
     * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
     * @param n
     * @return
     */
    @Override
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        if (n <= 1) return G[n];
        for (int m = 2; m <= n; m++) {
            for (int i = 0; i < m; i++) {
                G[m] += G[i] * G[m - 1 - i];
            }
        }
        return G[n];
    }
}
