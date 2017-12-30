import arcturus.util.ArrayUtils;
import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract TreeNode buildTree(int[] preorder, int[] inorder);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[4, 1, 5, #, 9, 10, 9, #, 16, #, #, 40, 90]");
        int[] preorder = ArrayUtils.toPrimitive(root.preorderTraversal().toArray(new Integer[0]));
        int[] inorder = ArrayUtils.toPrimitive(root.inorderTraversal().toArray(new Integer[0]));
        System.out.println(root.isSameTree(solution.buildTree(preorder, inorder)));
        root = TreeNode.parse("[1, 2]");
        preorder = ArrayUtils.toPrimitive(root.preorderTraversal().toArray(new Integer[0]));
        inorder = ArrayUtils.toPrimitive(root.inorderTraversal().toArray(new Integer[0]));
        System.out.println(root.isSameTree(solution.buildTree(preorder, inorder)));
    }
}
