import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static String nullString = "#";
    private static String seprator = ", ";
    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val) {
            this(val, null, null);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 层序遍历
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) result.append(seprator);
            if (node == null) {
                result.append(nullString);
            } else {
                result.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (!flag) flag = true;
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrings = data.split(seprator);
        TreeNode root = null;
        if (!nodeStrings[0].equals(nullString)) root = new TreeNode(Integer.valueOf(nodeStrings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodeStrings.length; i += 2) {
            TreeNode node1 = null, node2 = null;
            if (!nodeStrings[i].equals(nullString)) {
                node1 = new TreeNode(Integer.valueOf(nodeStrings[i]));
            }
            if (!nodeStrings[i + 1].equals(nullString)) {
                node2 = new TreeNode(Integer.valueOf(nodeStrings[i + 1]));
            }
            TreeNode preNode = queue.poll();
            preNode.left = node1;
            preNode.right = node2;
            if (node1 != null) queue.add(node1);
            if (node2 != null) queue.add(node2);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String encode = solution.serialize(root);
        System.out.println(encode);
        TreeNode newRoot = solution.deserialize(encode);
        System.out.println(solution.serialize(newRoot));
    }
}
