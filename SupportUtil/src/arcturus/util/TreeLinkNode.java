package arcturus.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLinkNode {
    public static final String NULL_STRING = "#";
    public static final String SEPARATOR = ", ";
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeLinkNode(int val) {
        this(val, null, null);
    }


    /**
     * 将给定的字符串数据转化为二叉树。
     *
     * @param data 字符串数据
     * @return 转化的二叉树根节点
     * @throws FormatException 转换失败时抛出异常
     */
    public static TreeLinkNode parse(String data) throws FormatException {
        return parse(data, SEPARATOR, NULL_STRING);
    }

    /**
     * 利用给定的分隔符，将给定的字符串数据转化为二叉树。
     *
     * @param data      字符串数据
     * @param separator 分隔符
     * @return 转化的二叉树根节点
     * @throws FormatException 转换失败时抛出异常
     */
    public static TreeLinkNode parse(String data, String separator) throws FormatException {
        return parse(data, separator, NULL_STRING);
    }

    /**
     * 利用给定的分隔符和{@code nullString}，将给定的字符串数据转化为二叉树
     *
     * @param data       字符串数据
     * @param separator  分隔符
     * @param nullString 表示null节点的字符串
     * @return 转化的二叉树根节点
     * @throws FormatException 转换失败时抛出异常
     */
    public static TreeLinkNode parse(String data, String separator, String nullString)
            throws FormatException {
        String[] nodeStrings = data.replace("[", "").replace("]", "").split(separator);
        TreeLinkNode root = null;
        try {
            if (!nodeStrings[0].equals(nullString)) root = new TreeLinkNode(Integer.valueOf(nodeStrings[0]));
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.add(root);
            for (int i = 1; i < nodeStrings.length; i += 2) {
                TreeLinkNode node1 = null, node2 = null;
                if (!nodeStrings[i].equals(nullString)) {
                    node1 = new TreeLinkNode(Integer.valueOf(nodeStrings[i]));
                }
                if (i + 1 < nodeStrings.length && !nodeStrings[i + 1].equals(nullString)) {
                    node2 = new TreeLinkNode(Integer.valueOf(nodeStrings[i + 1]));
                }
                TreeLinkNode preNode = queue.poll();
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

    public List<Integer> asList() {
        return this.inorderTraversal();
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderCore(this, result);
        return result;
    }

    private void preorderCore(TreeLinkNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderCore(node.left, result);
            preorderCore(node.right, result);
        }
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderCore(this, result);
        return result;
    }

    private void inorderCore(TreeLinkNode node, List<Integer> result) {
        if (node != null) {
            inorderCore(node.left, result);
            result.add(node.val);
            inorderCore(node.right, result);
        }
    }

    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorderCore(this, result);
        return result;
    }

    private void postorderCore(TreeLinkNode node, List<Integer> result) {
        if (node != null) {
            postorderCore(node.left, result);
            postorderCore(node.right, result);
            result.add(node.val);
        }
    }
}
