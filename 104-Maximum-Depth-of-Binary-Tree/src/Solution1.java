import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：获得一个二叉树的最大深度
     * @param root
     * @return
     */
    @Override
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
