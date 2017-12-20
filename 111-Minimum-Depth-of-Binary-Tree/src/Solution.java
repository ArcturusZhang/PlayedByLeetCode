import arcturus.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 题目描述：获得一个二叉树所有叶子中最小的深度
     * 解：
     * 利用层序遍历来解。维护一个变量记录层数，同时进行层序遍历，同时查看每个节点是否为叶子，如果是叶子直接返回结果。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int min = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            min++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return min;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[1, 2, #, 3, #, 4, 5, 6, #, #, 7, #, 10]");
        System.out.println(solution.minDepth(root));
    }
}
