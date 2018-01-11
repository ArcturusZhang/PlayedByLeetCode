import arcturus.util.ListNode;

import java.util.Stack;

public class Solution2 extends Solution {
    /**
     * 利用一个栈，将链表反转。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    @Override
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode phead = new ListNode(0), pnode = phead;
        while (!stack.isEmpty()) {
            pnode.next = stack.pop();
            pnode = pnode.next;
        }
        pnode.next = null;
        return phead.next;
    }
}
