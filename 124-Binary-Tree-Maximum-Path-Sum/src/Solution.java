import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract int maxPathSum(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        TreeNode root = TreeNode.parse("-10,9,20,#,#,15,7", ",");
        System.out.println(solution.maxPathSum(root));
        root = TreeNode.parse("1,2,3", ",");
        System.out.println(solution.maxPathSum(root));
        root = TreeNode.parse("2,-1", ",");
        System.out.println(solution.maxPathSum(root));
    }
}
