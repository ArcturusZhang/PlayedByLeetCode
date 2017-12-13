import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /**
     * 递归版本——很简单
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalCore(root, result);
        return result;
    }

    private void inorderTraversalCore(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversalCore(node.left, result);
            result.add(node.val);
            inorderTraversalCore(node.right, result);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        TreeNode root = TreeNode.parse("[1, #, 2, 3]");
        System.out.println(solution1.inorderTraversal(root));
        System.out.println(solution2.inorderTraversal(root));
    }
}
