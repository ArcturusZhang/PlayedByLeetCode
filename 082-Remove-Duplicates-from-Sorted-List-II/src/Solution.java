import arcturus.util.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(ListNode.toString(solution.deleteDuplicates(ListNode.parse("[1,1,1,2,3,3,5]"))));
    }
}
