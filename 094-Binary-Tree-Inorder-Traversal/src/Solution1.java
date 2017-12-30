import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 递归版本——很简单
     * @param root
     * @return
     */
    @Override
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
}
