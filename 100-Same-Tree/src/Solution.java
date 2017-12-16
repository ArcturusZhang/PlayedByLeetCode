import arcturus.util.TreeNode;

public class Solution {
    /**
     * 题目描述：判定两个二叉树是否相同
     * 解：
     * 递归进行即可。两个相同的二叉树要求根相同，而且左树相同，右树也相同。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = TreeNode.parse("[1, 2, 3]");
        TreeNode q = TreeNode.parse("[1, 2, 3]");
        System.out.println(solution.isSameTree(p, q));
    }
}
