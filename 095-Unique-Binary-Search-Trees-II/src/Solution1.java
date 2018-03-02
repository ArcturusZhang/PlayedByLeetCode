import arcturus.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 很简单的递归方法。
     * 首先按顺序选择一个数字i作为根元素，将1至i-1的数字生成的二叉搜索树作为i的左孩子，将i+1至n的数字生成的二叉搜索树作为i的右孩子
     * @param n
     * @return
     */
    @Override
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateCore(1, n + 1);
    }

    /**
     * 注：生成从start开始，至end-1结束的所有二叉搜索树
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateCore(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start >= end) {
            result.add(null);
            return result;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> leftNodes = generateCore(start, i);
            List<TreeNode> rightNodes = generateCore(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
