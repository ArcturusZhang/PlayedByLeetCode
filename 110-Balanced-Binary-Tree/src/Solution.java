import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract boolean isBalanced(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[10, 8, 9, 7, 4, 3, #, 6, 5]");
        System.out.println(solution.isBalanced(root));
    }
}
