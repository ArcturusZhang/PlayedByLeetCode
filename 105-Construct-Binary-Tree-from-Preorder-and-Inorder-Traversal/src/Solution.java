import arcturus.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return new TreeNode(-10);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.parse("[4, 1, 5, #, 9, 10, 9, #, 16, #, #, 40, 90]");
        int[] preorder = ArrayUtils.toPrimitive(root.preorderTraversal().toArray(new Integer[0]));
        int[] inorder = ArrayUtils.toPrimitive(root.inorderTraversal().toArray(new Integer[0]));
        System.out.println(solution.buildTree(preorder, inorder).toArrayList());
    }
}
