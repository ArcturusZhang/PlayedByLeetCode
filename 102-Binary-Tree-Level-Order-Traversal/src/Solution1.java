import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 extends Solution {
    /**
     * 题目描述：实现二叉树的层序遍历
     * @param root
     * @return
     */
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int level = queue.size(), next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current.add(node.val);
            level--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (level == 0) { // 转下一行
                result.add(current);
                current = new ArrayList<>();
                level = next;
                next = 0;
            }
        }
        return result;
    }
}
