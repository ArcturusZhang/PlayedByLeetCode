import arcturus.util.TreeLinkNode;

public abstract class Solution {
    public abstract void connect(TreeLinkNode root);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        TreeLinkNode root = TreeLinkNode.parse("[1, 2, 3, 4, 5, 6, 7]");
        solution.connect(root);
    }
}
