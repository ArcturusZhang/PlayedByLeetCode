import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 很简单的题目，事实上很多链表题目都是可以修改节点值的，这可以使得问题大为简化
     * @param node
     */
    @Override
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
