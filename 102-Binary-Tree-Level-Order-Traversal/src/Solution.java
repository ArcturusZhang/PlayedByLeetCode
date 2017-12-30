import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> levelOrder(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[3,9,20,null,null,15,7]", ",", "null");
        System.out.println(solution.levelOrder(root));
    }
}
