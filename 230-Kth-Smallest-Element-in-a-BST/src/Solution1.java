import arcturus.util.TreeNode;

import java.util.Stack;

public class Solution1 extends Solution {
    /**
     * 二叉树中序遍历的修改版本
     * @param root
     * @param k
     * @return
     */
    @Override
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        while (k > 0 && (node != null || !stack.isEmpty())) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            result = node.val;
            node = node.right;
        }
        return result;
    }
}
