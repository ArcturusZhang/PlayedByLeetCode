import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract int minDepth(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[1, 2, #, 3, #, 4, 5, 6, #, #, 7, #, 10]");
        System.out.println(solution.minDepth(root));
    }
}
