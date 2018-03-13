import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 在BST上，两个节点的公共祖先的值应该介于两个节点之间。
     * 如果当前的根值大于p和q的值，说明p和q都在根的左子树上
     * 如果当前的根值小于p和q的值，说明p和q都在根的右子树上
     * @param root
     * @param p
     * @param q
     * @return
     */
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
