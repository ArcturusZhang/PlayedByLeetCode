import arcturus.util.ListNode;

import java.util.Stack;

public class Solution {
    /**
     * 题目描述：反转链表中的第m到第n个节点之间的部分，其余部分保持原顺序
     * 解：
     * 反转链表的题目基本上都是用栈实现的（我都是这样做的）。也可以利用三个指针来达到反转的目的。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode phead = new ListNode(0);
        Stack<ListNode> stack = new Stack<>();
        int count = 1;
        ListNode node = head, pnode = phead;
        while (node != null) {
            if (count < m) {
                pnode.next = node;
                pnode = pnode.next;
            } else if (count <= n) {
                stack.push(node);
            } else {
                break;
            }
            node = node.next;
            count++;
        }
        while (!stack.isEmpty()) {
            pnode.next = stack.pop();
            pnode = pnode.next;
        }
        pnode.next = node;
        return phead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5]");
        System.out.println(ListNode.toString(solution.reverseBetween(head, 1, 3)));
    }
}
