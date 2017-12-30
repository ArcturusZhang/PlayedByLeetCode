import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 extends Solution {
    /**
     * 这是{@code Solution1}的精简优化版
     * @param root
     * @return
     */
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) { // 这里的i只是起计数作用，由于queue的size在循环过程中会改变，所以令i倒序变化
                TreeNode node = queue.poll();
                current.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(current);
        }
        return result;
    }
}
