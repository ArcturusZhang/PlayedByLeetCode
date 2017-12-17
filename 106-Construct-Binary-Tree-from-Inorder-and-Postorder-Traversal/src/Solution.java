import arcturus.util.ArrayUtils;
import arcturus.util.TreeNode;

public class Solution {
    /**
     * 本题与105几乎相同。
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart > iend) return null;
        TreeNode node = new TreeNode(postorder[pend]);
        int pos = istart;
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == postorder[pend]) {
                pos = i;
                break;
            }
        }
        node.left = buildTreeCore(inorder, istart, pos - 1, postorder, pstart, pos - 1 + pstart - istart);
        node.right = buildTreeCore(inorder, pos + 1, iend, postorder, pos + pend - iend, pend - 1);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[8, 1, 3, #, 10, 5, #, 9, #, 2, 4");
        int[] inorder = ArrayUtils.toPrimitive(root.inorderTraversal().toArray(new Integer[0]));
        int[] postorder = ArrayUtils.toPrimitive(root.postorderTraversal().toArray(new Integer[0]));
        System.out.println(root.isSameTree(solution.buildTree(inorder, postorder)));
    }
}
