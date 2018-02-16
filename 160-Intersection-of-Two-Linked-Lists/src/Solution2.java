import arcturus.util.ListNode;

public class Solution2 extends Solution {
    /**
     * 原理类似于寻找链表中环开始节点的例子。
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
