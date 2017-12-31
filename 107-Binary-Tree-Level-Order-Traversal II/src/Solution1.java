import arcturus.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 extends Solution {
    /**
     * 本题与102的层序遍历基本完全相同，按层倒序排列只需要每次插入新层时插入在列表开头即可。
     * @param root
     * @return
     */
    @Override
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> current = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                current.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(0, current);
        }
        return result;
    }
}
