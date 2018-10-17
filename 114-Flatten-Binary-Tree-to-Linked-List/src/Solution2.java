import arcturus.util.TreeNode;

public class Solution2 extends Solution {
    @Override
    public void flatten(TreeNode root) {
        flattenCore(root);
    }

    private TreeNode flattenCore(TreeNode root) {
        if (root == null) return null;
        TreeNode left = flattenCore(root.left);
        TreeNode right = flattenCore(root.right);
        root.left = null;
        root.right = left;
        TreeNode node = root;
        while (node.right != null) node = node.right;
        node.right = right;
        return root;
    }
}
