import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[6, 2, 8, 0, 4, 7, 9, #, #, 3, 5]");
        System.out.println(solution.lowestCommonAncestor(root, root.getForValue(2), root.getForValue(4)));
        System.out.println(solution.lowestCommonAncestor(root, root.getForValue(2), root.getForValue(8)));
    }
}
