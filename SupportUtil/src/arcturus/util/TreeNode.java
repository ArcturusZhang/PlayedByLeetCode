package arcturus.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树类，不加任何限制的二叉树
 */
public class TreeNode {
    public static final String NULL_STRING = "#";
    public static final String SEPARATOR = ", ";
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * 构造器。同时指定数值，左儿子和右儿子
     *
     * @param val   数值
     * @param left  左儿子
     * @param right 右儿子
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 构造器。只指定数值
     *
     * @param val 数值
     */
    public TreeNode(int val) {
        this(val, null, null);
    }

    /**
     * 利用层序遍历，将二叉树转化为字符串。其中{@code null}节点的转换结果由常量{@code NULL_STRING}决定。
     *
     * @param root 二叉树的根节点
     * @return 转换结果
     */
    public static String toString(TreeNode root) {
        return TreeNode.toString(root, SEPARATOR, NULL_STRING);
    }

    /**
     * 利用层序遍历，根据传入的分隔符和{@code nullString}将二叉树转化为字符串。
     *
     * @param root       二叉树的根节点
     * @param separator  分隔符
     * @param nullString 表示null节点的字符串
     * @return 转换结果
     */
    public static String toString(TreeNode root, String separator, String nullString) {
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

    /**
     * 将给定的字符串数据转化为二叉树。
     *
     * @param data 字符串数据
     * @return 转化的二叉树根节点
     * @throws FormatException 转换失败时抛出异常
     */
    public static TreeNode parse(String data) throws FormatException {
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
    public static TreeNode parse(String data, String separator) throws FormatException {
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
    public static TreeNode parse(String data, String separator, String nullString)
            throws FormatException {
        String[] nodeStrings = data.replace("[", "").replace("]", "").split(separator);
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
                if (i + 1 < nodeStrings.length && !nodeStrings[i + 1].equals(nullString)) {
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

    /**
     * 利用中序遍历将二叉树展平为一个列表
     *
     * @return 转换结果
     * @see TreeNode#inorderTraversal()
     */
    public List<Integer> asList() {
        return this.inorderTraversal();
    }

    /**
     * 利用中序遍历将二叉树展平为一个列表
     *
     * @return 转换结果
     * @see TreeNode#inorderTraversal()
     */
    @Deprecated
    public List<Integer> toArrayList() {
        return this.inorderTraversal();
    }

    /**
     * 利用前序遍历将二叉树展平为一个列表
     *
     * @return 转换结果
     */
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderCore(this, result);
        return result;
    }

    private void preorderCore(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderCore(node.left, result);
            preorderCore(node.right, result);
        }
    }

    /**
     * 利用中序遍历将二叉树展平为一个列表
     *
     * @return 转换结果
     * @see TreeNode#asList()
     */
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderCore(this, result);
        return result;
    }

    private void inorderCore(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderCore(node.left, result);
            result.add(node.val);
            inorderCore(node.right, result);
        }
    }

    /**
     * 利用后序遍历将二叉树展平为一个列表
     *
     * @return 转换结果
     */
    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorderCore(this, result);
        return result;
    }

    private void postorderCore(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorderCore(node.left, result);
            postorderCore(node.right, result);
            result.add(node.val);
        }
    }

    /**
     * 获得二叉树的层序遍历结果。
     *
     * @return 转换结果
     */
    public List<List<Integer>> levelOrderTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                current.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(current);
        }
        return result;
    }

    /**
     * 获得二叉树的最大深度（最大层数）
     *
     * @return 树的最大层数
     */
    public int maxDepth() {
        return depth(this);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    /**
     * 判定给定的树与本树是否完全相同
     *
     * @param root 给定树
     * @return 如果相同，返回{@code true}，否则返回{@code false}
     */
    public boolean isSameTree(TreeNode root) {
        return isSameTreeCore(this, root);
    }

    private boolean isSameTreeCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isSameTreeCore(node1.left, node2.left) && isSameTreeCore(node1.right, node2.right);
    }

    @Override
    public String toString() {
        return "TreeNode : val = " + this.val;
    }
}
