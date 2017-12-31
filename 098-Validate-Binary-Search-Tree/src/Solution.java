import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract boolean isValidBST(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[2, 1, 3]");
        System.out.println(root.asList());
        System.out.println(solution.isValidBST(root));
        root = TreeNode.parse("[1, 2, 3]");
        System.out.println(root.asList());
        System.out.println(solution.isValidBST(root));
    }
}
