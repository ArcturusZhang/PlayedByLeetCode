import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract boolean isSymmetric(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        TreeNode root = TreeNode.parse("[3, 1, 1, 3, #, #, 3]");
        System.out.println(solution.isSymmetric(root));
        root = TreeNode.parse("[3, 1, 1, 3, #, 3, #]");
        System.out.println(solution.isSymmetric(root));
    }
}
