import arcturus.util.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/validate-binary-search-tree/description/</url>
     * 解：
     * 正确的二叉搜索树如果利用中序遍历展平得到的结果应该是一个单调上升的列表。
     * 所以这里利用二叉树的中序遍历，同时不断查看当前节点的数值是否严格大于前一个节点的数值。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (last != null && last.val >= node.val) return false; // 判断二叉搜索树的核心
            last = node;
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[2, 1, 3]");
        System.out.println(root.toArrayList());
        System.out.println(solution.isValidBST(root));
        root = TreeNode.parse("[1, 2, 3]");
        System.out.println(root.toArrayList());
        System.out.println(solution.isValidBST(root));
    }
}
