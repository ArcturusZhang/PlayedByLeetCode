import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 遍历链表，同时移除相应的节点即可
     *
     * @param head
     * @param val
     * @return
     */
    @Override
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode phead = new ListNode(0), last = phead;
        phead.next = head;
        while (head != null) {
            if (head.val == val) {
                last.next = head.next;
            } else last = head;
            head = head.next;
        }
        return phead.next;
    }
}
