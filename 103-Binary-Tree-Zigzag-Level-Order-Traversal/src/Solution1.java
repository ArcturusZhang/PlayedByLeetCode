import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 extends Solution {
    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int level = queue.size(), next = 0, direction = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level--;
            if (direction > 0) current.add(node.val);
            else current.add(0, node.val);
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (level == 0) {
                result.add(current);
                current = new ArrayList<>();
                level = next;
                next = 0;
                direction = -direction;
            }
        }
        return result;
    }
}
