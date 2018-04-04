import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract int sumNumbers(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[1, 2, 3]");
        System.out.println(solution.sumNumbers(root));
        root = TreeNode.parse("[1, 2, 3, #, 5, #, 9, 10]");
        System.out.println(solution.sumNumbers(root));
    }
}
