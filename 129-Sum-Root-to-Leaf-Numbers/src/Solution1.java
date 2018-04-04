import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    int sum;
    @Override
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int current) {
        if (node == null) return;
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += current;
            return;
        }
        dfs(node.left, current);
        dfs(node.right, current);
    }
}
