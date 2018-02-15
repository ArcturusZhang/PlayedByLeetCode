import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<Integer> postorderTraversal(TreeNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
        testCases(new Solution3());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeNode root;
        root = TreeNode.parse("[1, #, 2, 3, #]");
        System.out.println(solution.postorderTraversal(root));
    }
}
