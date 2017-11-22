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
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode slow = phead, fast = phead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            // TODO
        }
        return phead.next;
    }
}
