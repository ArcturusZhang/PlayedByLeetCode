import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/binary-search-tree-iterator/description/</url>
     * 解：
     * 本题要求实现一个二叉搜索树的迭代器。
     * 将中序遍历的非迭代版本拆开即可实现。
     * @param root
     */
    TreeNode current;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.isEmpty() ? null : stack.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = current;
        current = current.right;
        if (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
        }
        return node.val;
    }
}
