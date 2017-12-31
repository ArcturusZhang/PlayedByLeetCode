import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> levelOrderBottom(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[5, 3, 2, #, 10, 9, 0, #, 18, #");
        System.out.println(solution.levelOrderBottom(root));
    }
}
