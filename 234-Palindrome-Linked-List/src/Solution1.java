import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 由于题目要求不使用额外的空间，所以我的用栈翻转链表大法在这里不能用了。
     * 思路仍然很简单，第一步先将链表从中间断开
     * 第二步将断开的链表后半部分翻转（逐对节点考察，依次将其指向翻转）
     * 第三步循环考察翻转后的后半部分和前半部分是否相同。
     * 如果链表长度是偶数，那么前半段和后半段长度相等；如果链表长度是奇数，那么前半段比后半段长1。所以只需对后半段链表进行遍历，逐个比较即可。
     * @param head
     * @return
     */
    @Override
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 第一步，将链表从中间断开
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next, last = null;
        slow.next = null;
        // 将链表的后半段翻转
        while (node != null) {
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        node = head;
        while (last != null) {
            if (last.val != node.val) return false;
            last = last.next;
            node = node.next;
        }
        return true;
    }
}
