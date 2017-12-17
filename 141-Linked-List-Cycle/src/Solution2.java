import arcturus.util.ListNode;

import java.util.HashSet;

public class Solution2 {
    /**
     * 利用一个{@code HashSet}储存已经经过过的节点，如果出现了重复节点，即说明链表中有环。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.add(node)) return true;
            node = node.next;
        }
        return false;
    }
}
