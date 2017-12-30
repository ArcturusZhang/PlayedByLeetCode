import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract int maxDepth(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        TreeNode root = TreeNode.parse("[2, 1, 8, 9, #, 19, 3, #, #, 10]");
        System.out.println(root.levelOrderTraversal());
        System.out.println(solution.maxDepth(root));
    }
}
