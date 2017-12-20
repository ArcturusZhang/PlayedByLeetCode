import arcturus.util.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/</url>
     * 解：
     * 展平的结果即为利用前序遍历生成的，所以解法上也直接利用前序遍历算法即可。
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            node.left = null;
            node.right = stack.pop();
            node = node.right;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[1, 2, 5, 3, 4, #, 6]");
        solution.flatten(root);
        System.out.println(root.toStringAll());
    }
}
