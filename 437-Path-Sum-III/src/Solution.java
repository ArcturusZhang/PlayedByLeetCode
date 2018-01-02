import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract int pathSum(TreeNode root, int sum);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        TreeNode root = TreeNode.parse("[1,null,2,null,3,null,4,null,5]", ",", "null");
        System.out.println(solution.pathSum(root, 3));
    }
}
