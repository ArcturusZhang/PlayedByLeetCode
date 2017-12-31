import arcturus.util.ListNode;

public class Solution1 extends Solution {
    @Override
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode node = head, pnode = phead;
        while (node != null) {
            while (node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            if (pnode.next != node) { // 发现重复
                pnode.next = node.next;
                node = node.next;
            } else { // 没有重复
                pnode = pnode.next;
                node = node.next;
            }
        }
        return phead.next;
    }
}
