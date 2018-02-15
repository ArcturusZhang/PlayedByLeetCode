import arcturus.util.ListNode;

public class Solution2 extends Solution {
    /**
     * 首先将链表从中间断开，然后将后半部分倒序排列，最后将后半部分相应的节点插入对应的位置
     *
     * @param head
     */
    @Override
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 将链表从中间断开
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将后半部分反向  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }
        // 将后半部分的节点插入相应的位置  1->2->3->6->5->4 to 1->6->2->5->3->4
        slow = head;
        fast = preMiddle.next;
        while (slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMiddle.next;
        }
    }
}
