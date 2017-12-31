import arcturus.util.TreeLinkNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/</url>
     * 解：
     * 题目假定树一定是满的，大大降低了题目的难度。
     * 每一行都是一个链表，所以这里也使用和链表类似的虚拟头节点来处理，以避免NullPointerException和很多if判断
     * @param root
     */
    @Override
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode phead = new TreeLinkNode(0);
        TreeLinkNode last = phead;
        TreeLinkNode node = root;
        while (node != null) {
            // 遍历本行，同时链接下一行
            if (node.left != null) {
                last.next = node.left;
                last = last.next;
            }
            if (node.right != null) {
                last.next = node.right;
                last = last.next;
            }
            node = node.next;
            // 换到下一行去
            if (node == null) {
                last = phead;
                node = phead.next; // 这就是下一行的开头
                phead.next = null;
            }
        }
    }
}
