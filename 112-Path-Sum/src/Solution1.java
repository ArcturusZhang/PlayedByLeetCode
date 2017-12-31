import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/path-sum/description/</url>
     * 解：
     * 本题目比较简单。需要注意的是要加到叶子节点才算数
     * @param root
     * @param sum
     * @return
     */
    @Override
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumCore(root, sum);
    }

    private boolean hasPathSumCore(TreeNode node, int sum) {
        if (node != null) {
            if (node.val == sum && node.left == null && node.right == null) return true;
            return hasPathSumCore(node.left, sum - node.val) || hasPathSumCore(node.right, sum - node.val);
        }
        return false;
    }
}
