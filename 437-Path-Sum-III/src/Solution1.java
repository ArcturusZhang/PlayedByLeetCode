import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/path-sum-iii/description/</url>
     * 解：
     * 回溯法。虽然这题目是个EASY，但是还挺难的。。。跟前面的回溯法做法不太一样
     * pathSum返回以root为根的树中所有可能的路径数目（不必从根开始），而pathSumFrom只返回从根开始的所有可能路径
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        int result = 0;
        if (node.val == sum) result++;
        result += pathSumFrom(node.left, sum - node.val);
        result += pathSumFrom(node.right, sum - node.val);
        return result;
    }
}
