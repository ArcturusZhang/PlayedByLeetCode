import arcturus.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 extends Solution {
    /**
     * 利用HashSet的简单实现
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(N)
     * @param headA
     * @param headB
     * @return
     */
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) return node;
            node = node.next;
        }
        return null;
    }
}
