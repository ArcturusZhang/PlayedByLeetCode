import arcturus.util.TreeNode;

public abstract class Solution {

    public abstract int kthSmallest(TreeNode root, int k);
    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[6, 3, 9, 2, 5, 7, #, 1, #, 4, #, #, 8]");
        for (int i = 1; i <= 9; i++)
            System.out.println(solution.kthSmallest(root, i));
    }
}
