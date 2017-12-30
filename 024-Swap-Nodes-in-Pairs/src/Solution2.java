import arcturus.util.ListNode;

public class Solution2 extends Solution {
    /**
     * 用双指针的实现。这种方法很难拓展。
     * @param head
     * @return
     */
    @Override
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode node, last, next;
        last = pHead;
        node = last.next.next;
        while (node != null) {
            next = node.next;
            node.next = last.next;
            last.next = node;
            node.next.next = next;
            last = node.next;
            if (next != null) node = next.next;
            else node = null;
        }
        return pHead.next;
    }
}
