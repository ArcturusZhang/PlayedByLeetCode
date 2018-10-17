import arcturus.util.*;

public class Solution1 extends Solution {
    /**
     * 题目描述：利用给出的前序遍历和中序遍历的结果（两个数组），还原二叉树。
     * 解：
     * 递归求解。前序遍历得到的结果具有这样的递归结构：
     *      根节点  左子树的前序遍历结果  右子树的前序遍历结果
     * 中序遍历得到的结果具有这样的递归结构：
     *      左子树的中序遍历结果  根节点  右子树的中序遍历结果
     * 先利用前序遍历数组得到根节点，然后依次递归求解即可
     * @param preorder
     * @param inorder
     * @return
     */
    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeCore(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft >= preRight || inLeft >= inRight) return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // find index of rootVal in inorder array
        int index = inLeft;
        for (; index < inRight; index++) {
            if (inorder[index] == rootVal) break;
        }
        int leftNum = index - inLeft, rightNum = inRight - (index + 1);
        root.left = buildTreeCore(preorder, inorder, preLeft + 1, preLeft + 1 + leftNum,
                inLeft, index);
        root.right = buildTreeCore(preorder, inorder, preRight - rightNum, preRight,
                inRight - rightNum, inRight);
        return root;
    }
}
