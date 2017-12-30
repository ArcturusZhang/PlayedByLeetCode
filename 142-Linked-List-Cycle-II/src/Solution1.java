import arcturus.util.ListNode;

public class Solution1 extends Solution {
    @Override
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    slow = slow.next;
                    node = node.next;
                }
                return slow;
            }
        }
        return null;
    }
}
