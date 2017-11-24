import arcturus.util.ListNode;

import java.util.Stack;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/reverse-nodes-in-k-group/description/</url>
     * 解：
     * 基本上与024如出一辙，但是对于不足K个的结尾需要特殊处理，这部分不翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode phead = new ListNode(0);
        ListNode node = head, last = phead, remainder = null;
        while (node != null) {
            remainder = node;
            for (int i = 0; i < k; i++) {
                if (node == null) {
                    break;
                }
                stack.push(node);
                node = node.next;
            }
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    last.next = stack.pop();
                    last = last.next;
                }
            }
        }
        if (!stack.isEmpty()) {
            while (remainder != null) {
                last.next = remainder;
                last = last.next;
                remainder = remainder.next;
            }
        }
        last.next = null; // 防止成环
        return phead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 0)));
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 1)));
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 2)));
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 3)));
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 4)));
        System.out.println(ListNode.toString(solution.reverseKGroup(ListNode.parseListNode("[1,2,3,4,5]"), 5)));
    }
}
