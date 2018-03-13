import arcturus.util.TreeNode;

public abstract class Solution {
    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[3, 5, 1, 6, 2, 0, 8, #, #, 7, 4]");
        System.out.println(solution.lowestCommonAncestor(root, root.getForValue(5), root.getForValue(1)));
        System.out.println(solution.lowestCommonAncestor(root, root.getForValue(5), root.getForValue(4)));
    }

    public abstract TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
