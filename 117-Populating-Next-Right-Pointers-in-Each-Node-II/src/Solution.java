import arcturus.util.TreeLinkNode;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/</url>
     * 解：
     * 本题和116基本相同，只是去掉了"树一定是满的"这个附加条件。但实际上，上一题的解法已经很普遍，可以直接拿来当作本题答案。
     * 与116题相同，本题本质上也是一个链表的题目，所以也是利用链表中的虚拟头节点方式来求解的。
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        TreeLinkNode phead = new TreeLinkNode(0);
        TreeLinkNode last = phead;
        while (node != null) {
            if (node.left != null) {
                last.next = node.left;
                last = last.next;
            }
            if (node.right != null) {
                last.next = node.right;
                last = last.next;
            }
            node = node.next;
            // 换行
            if (node == null) {
                last = phead;
                node = phead.next; // 这就是下一行的开头
                phead.next = null;
            }
        }
    }
}
