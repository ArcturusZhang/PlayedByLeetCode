import arcturus.util.ListNode;

public class Solution1 extends Solution {
    @Override
    /**
     * 解：
     * 题目要求时间复杂度为O(N*log(N))，那么候选算法就只剩下归并排序和堆排序。
     * 而堆排序涉及到对索引的操作，并不适合链表，所以这里就使用归并排序来实现算法。
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSortCore(head);
    }

    private ListNode mergeSortCore(ListNode head) {
        if (head.next == null) return head; // 递归出口，即列表中只有一个元素的情形。
        else {
            // 将链表拆成两部分
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) { // 获得链表的中点
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = slow.next; // 从中点处断开
            slow.next = null;
            head = mergeSortCore(head); // 递归排序链表的前半部分
            fast = mergeSortCore(fast); // 递归排序链表的后半部分
            return mergeSortedList(head, fast); // 将排序过的前半部分和后半部分合并之后返回
        }
    }
    private ListNode phead = new ListNode(0); // 这个变量是为了严格满足常数级空间复杂度而存在的，将其作为mergeSortedList方法的局部变量也完全可以
    private ListNode mergeSortedList(ListNode head1, ListNode head2) {
        ListNode pnode = phead;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                pnode.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                pnode.next = head1;
                head1 = head1.next;
            } else {
                if (head1.val < head2.val) {
                    pnode.next = head1;
                    head1 = head1.next;
                } else {
                    pnode.next = head2;
                    head2 = head2.next;
                }
            }
            pnode = pnode.next;
        }
        return phead.next;
    }
}
