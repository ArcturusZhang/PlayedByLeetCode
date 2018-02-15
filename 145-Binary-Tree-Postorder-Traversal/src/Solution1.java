import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 递归实现
     * @param root
     * @return
     */
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        postorderCore(root, result);
        return result;
    }

    private void postorderCore(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderCore(root.left, result);
        postorderCore(root.right, result);
        result.add(root.val);
    }
}
