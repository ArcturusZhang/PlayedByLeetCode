import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract boolean hasPathSum(TreeNode root, int sum);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[5, 4, 8, 11, #, 13, 4, 7, 2, #, #, #, 1]");
        System.out.println(solution.hasPathSum(root, 22));
    }
}
