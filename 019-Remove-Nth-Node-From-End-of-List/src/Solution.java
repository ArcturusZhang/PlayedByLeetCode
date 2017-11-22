import arcturus.util.*;
public class Solution {
    /**
     * 题目描述：<@url>https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/</@url>
     * 删除一个单向链表中的倒数第k个节点。
     * 解：
     * 对于这种问题一般都是利用“双指针法”，来一次找到需要的位置。有快慢两个指针，慢指针指向开头，快指针则指向慢指针之后的第k个节点，然后让两个指针
     * 同时向尾端，直到快指针指向末尾，那么慢指针所指向的就是倒数第k个节点，然后删除之即可只遍历链表一次就完成删除任务。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode slow = phead, fast = phead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除slow.next
        slow.next = slow.next.next;
        return phead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 0)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 1)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 2)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 3)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 4)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 5)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parseListNode("[1, 2, 3, 4, 5]"), 6)));
    }
}
