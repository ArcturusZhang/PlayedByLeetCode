import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：判定一个二叉树是否为对称的。
     * 解：
     * 递归进行即可。
     * @param root
     * @return
     */
    @Override
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null) return false;
        if (node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
