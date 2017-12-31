import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract void recoverTree(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[0, 1, 2]");
        System.out.println(root.asList());
        solution.recoverTree(root);
        System.out.println(root.asList());
        root = TreeNode.parse("[0, 1]");
        System.out.println(root.asList());
        solution.recoverTree(root);
        System.out.println(root.asList());
        root = TreeNode.parse("[2, 3, 1]");
        System.out.println(root.asList());
        solution.recoverTree(root);
        System.out.println(root.asList());
    }
}
