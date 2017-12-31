import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：判断一个给定的二叉树是否平衡。
     * 解：
     * 平衡的定义是，二叉树中的每个节点的左子树和右子树的高度差绝对值不超过1。
     * 因此递归进行判定即可。
     * @param root
     * @return
     */
    @Override
    public boolean isBalanced(TreeNode root) {
        return isBalancedCore(root);
    }

    private boolean isBalancedCore(TreeNode node) {
        if (node == null) return true;
        return Math.abs(depth(node.left) - depth(node.right)) <= 1
                && isBalancedCore(node.left) && isBalancedCore(node.right);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
