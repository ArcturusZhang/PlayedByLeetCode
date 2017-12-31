import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract TreeNode sortedArrayToBST(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {1, 2, 4, 5, 8};
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root.asList());
        System.out.println(root.isBalanced());
    }
}
