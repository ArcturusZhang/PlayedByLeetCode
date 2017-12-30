import arcturus.util.ArrayUtils;
import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract TreeNode buildTree(int[] inorder, int[] postorder);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    public static void testCases(Solution solution) {
        TreeNode root = TreeNode.parse("[8, 1, 3, #, 10, 5, #, 9, #, 2, 4");
        int[] inorder = ArrayUtils.toPrimitive(root.inorderTraversal().toArray(new Integer[0]));
        int[] postorder = ArrayUtils.toPrimitive(root.postorderTraversal().toArray(new Integer[0]));
        System.out.println(root.isSameTree(solution.buildTree(inorder, postorder)));
    }
}
