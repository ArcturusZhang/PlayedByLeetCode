import arcturus.util.ListNode;

import java.util.Stack;

public class Solution1 {
    /**
     * 题目描述：<url>https://leetcode.com/problems/swap-nodes-in-pairs/description/</url>
     * 解：
     * 可以用双指针的方法来做（不太优雅），也可以用栈的方法来做。用栈可以推广反转任何相邻k个节点的题目。
     * 注意：需要注意防止链表在修改后成环
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode phead = new ListNode(0);
        ListNode node = head, last = phead;
        while (node != null) {
            for (int i = 0; i < 2; i++) {
                if (node == null) break;
                stack.push(node);
                node = node.next;
            }
            if (stack.size() == 2) {
                while (!stack.isEmpty()) {
                    last.next = stack.pop();
                    last = last.next;
                }
            }
        }
        while (!stack.isEmpty()) {
            last.next = stack.pop();
            last = last.next;
        }
        last.next = null; // 避免链表成环造成死循环
        return phead.next;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(ListNode.toString(solution1.swapPairs(ListNode.parse("[1, 2, 3, 4]"))));
        System.out.println(ListNode.toString(solution1.swapPairs(ListNode.parse("[1, 2, 3, 4, 5]"))));
        System.out.println(ListNode.toString(solution2.swapPairs(ListNode.parse("[1, 2, 3, 4]"))));
        System.out.println(ListNode.toString(solution2.swapPairs(ListNode.parse("[1, 2, 3, 4, 5]"))));
    }
}
