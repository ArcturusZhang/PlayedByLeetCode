import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    private int max;

    @Override
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        maxPathSumOneSide(root);
        return max;
    }

    private int maxPathSumOneSide(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathSumOneSide(root.left));
        int right = Math.max(0, maxPathSumOneSide(root.right));
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
