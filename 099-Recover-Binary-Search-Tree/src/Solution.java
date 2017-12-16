import arcturus.util.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/recover-binary-search-tree/description/</url>
     * 解：
     * 由于二叉搜索树的中序遍历得到的结果应该是严格递增的列表，如果有两个元素被交换了，那么这个列表中应该存在
     * 两个元素，其左边的元素大于自身。
     * 所以利用二叉树的中序遍历，从中找出这两个反序的元素，在遍历结束后再将这两个节点的值交换即可。
     * @param root
     */
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;
        TreeNode first = null, second = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (first == null && last != null && last.val > node.val) {
                first = last;
            }
            if (first != null && last != null && last.val > node.val) {
                second = node;
            }
            last = node;
            node = node.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[0, 1, 2]");
        System.out.println(root.toArrayList());
        solution.recoverTree(root);
        System.out.println(root.toArrayList());
        root = TreeNode.parse("[0, 1]");
        System.out.println(root.toArrayList());
        solution.recoverTree(root);
        System.out.println(root.toArrayList());
        root = TreeNode.parse("[2, 3, 1]");
        System.out.println(root.toArrayList());
        solution.recoverTree(root);
        System.out.println(root.toArrayList());
    }
}
