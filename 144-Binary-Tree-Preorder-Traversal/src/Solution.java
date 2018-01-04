import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<Integer> preorderTraversal(TreeNode root);

    public static void main(String[] args) {
        testCases(new RecursiveSolution());
        testCases(new NonRecursiveSolution());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root = TreeNode.parse("[1, #, 2, 3]");
        System.out.println(solution.preorderTraversal(root));
        System.out.println(root.preorderTraversal());
    }
}
