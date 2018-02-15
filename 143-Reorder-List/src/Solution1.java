import arcturus.util.ListNode;

import java.util.Stack;

public class Solution1 extends Solution {
    /**
     * 首先将链表从正中间断开，然后将后半段倒序，再合并即可
     * @param head
     */
    @Override
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 将链表从正中间断开
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将后半段链表压入栈中，以便一会倒序之
        ListNode node = slow.next;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        // 从头开始遍历，将链表的后半段插入前半段元素中适当的位置
        node = head;
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            next.next = node.next;
            node.next = next;
            node = next.next;
        }
        node.next = null; // 防止成环
    }
}
