import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 extends Solution {
    /**
     * 非递归版本
     * @param root
     * @return
     */
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, right = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            while (node.right == null || node.right == right) {
                result.add(node.val);
                right = node;
                if (stack.isEmpty()) return result;
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
        return result;
    }
}
