import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSolution extends Solution {
    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalCore(root, result);
        return result;
    }

    private void preorderTraversalCore(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderTraversalCore(node.left, result);
            preorderTraversalCore(node.right, result);
        }
    }
}
