package arcturus.util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    private static final String nullString = "#";
    private static final String separator = ", ";
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public static String toString(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) result.append(separator);
            if (node == null) {
                result.append(nullString);
            } else {
                result.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (!flag) flag = true;
        }
        return "[" + result.toString() + "]";
    }

    public static TreeNode parse(String data) {
        data = data.replace("[", "").replace("]", "");
        String[] nodeStrings = data.split(separator);
        TreeNode root = null;
        try {
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
        } catch (Exception e) {
            throw new FormatException(e);
        }
        return root;
    }
}
