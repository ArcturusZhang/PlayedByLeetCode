import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> pathSum(TreeNode root, int sum);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[5, 4, 8, 11, #, 13, 4, 7, 2, #, #, 5, 1]");
        System.out.println(solution.pathSum(root, 22));
    }
}
