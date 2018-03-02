import arcturus.util.TreeNode;

import java.util.List;

public abstract class Solution {
    public abstract List<TreeNode> generateTrees(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        for (int i = 1; i <= 5; i++) {
            List<TreeNode> list = solution.generateTrees(i);
            for (TreeNode root : list) {
                System.out.println(root.toStringAll());
            }
        }
    }
}
