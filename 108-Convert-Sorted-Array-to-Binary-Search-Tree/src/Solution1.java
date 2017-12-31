import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：将一个排序数组转化为平衡二叉树
     * 解：
     * 要求树是平衡的，所以需要将最中间的元素作为根。依此递归执行即可
     * @param nums
     * @return
     */
    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return arrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBSTCore(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBSTCore(nums, start, mid - 1);
        root.right = arrayToBSTCore(nums, mid + 1, end);
        return root;
    }
}
