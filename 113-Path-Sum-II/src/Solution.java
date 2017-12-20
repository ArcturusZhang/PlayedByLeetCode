import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/path-sum-ii/description/</url>
     * 解：
     * 回溯法。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumCore(root, sum, result, new ArrayList<>());
        return result;
    }

    private void pathSumCore(TreeNode node, int sum, List<List<Integer>> result, List<Integer> current) {
        if (node != null) {
            current.add(node.val);
            // 回溯出口
            if (node.left == null && node.right == null && node.val == sum) {
                result.add(new ArrayList<>(current));
            }
            pathSumCore(node.left, sum - node.val, result, current); // 尝试左孩子
            pathSumCore(node.right, sum - node.val, result, current); // 尝试右孩子
            current.remove(current.size() - 1); // 进行回溯
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[5, 4, 8, 11, #, 13, 4, 7, 2, #, #, 5, 1]");
        System.out.println(solution.pathSum(root, 22));
    }
}
