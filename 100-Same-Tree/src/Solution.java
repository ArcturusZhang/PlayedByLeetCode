import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract boolean isSameTree(TreeNode p, TreeNode q);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode p = TreeNode.parse("[1, 2, 3]");
        TreeNode q = TreeNode.parse("[1, 2, 3]");
        System.out.println(solution.isSameTree(p, q));
        q = TreeNode.parse("[1, 2, 4]");
        System.out.println(solution.isSameTree(p, q));
    }
}
