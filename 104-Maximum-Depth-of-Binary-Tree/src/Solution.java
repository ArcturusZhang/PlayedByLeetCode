import arcturus.util.TreeNode;

public class Solution {
    /**
     * 题目描述：获得一个二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[2, 1, 8, 9, #, 19, 3, #, #, 10]");
        System.out.println(root.levelOrderTraversal());
        System.out.println(solution.maxDepth(root));
        System.out.println(root.maxDepth());
    }
}
