import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 简单的链表题目。
     * @param head
     * @return
     */
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode node = head;
        ListNode last = null;
        while (node != null) {
            if (last != null && node.val == last.val) {
                last.next = node.next;
            } else {
                last = node;
            }
            node = node.next;
        }
        return phead.next;
    }
}
