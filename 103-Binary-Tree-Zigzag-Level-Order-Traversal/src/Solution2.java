import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 extends Solution {
    /**
     * 这只是{@code Solution1}的精简版
     * @param root
     * @return
     */
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        int direction = 1;
        while (!queue.isEmpty()) {
            List<Integer> current = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (direction > 0) current.add(node.val);
                else current.add(0, node.val);
            }
            result.add(current);
            direction = -direction;
        }
        return result;
    }
}
