import arcturus.util.TreeNode;

import java.util.Stack;

public class Solution1 extends Solution {
    /**
     * 二叉树中序遍历的修改版本
	 利用二叉查找树的中序遍历，同时维护一个变量计数。中序遍历得到的是二叉查找树按元素顺序的列表，通过计数变量即可找到第k小的元素。
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
