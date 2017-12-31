import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract void flatten(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[1, 2, 5, 3, 4, #, 6]");
        solution.flatten(root);
        System.out.println(root.toStringAll());
    }
}
