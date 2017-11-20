import arcturus.util.*;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode phead = new ListNode(0);
        ListNode last = phead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int digit = l1.val + l2.val + carry;
            carry = digit / 10;
            last.next = new ListNode(digit % 10);
            last = last.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) l1 = l2;
        while (l1 != null) {
            int digit = l1.val + carry;
            carry = digit / 10;
            last.next = new ListNode(digit % 10);
            last = last.next;
            l1 = l1.next;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return phead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parseListNode("[2, 4, 3]");
        ListNode l2 = ListNode.parseListNode("[5, 6, 4]");
        System.out.println(ListNode.toString(new Solution().addTwoNumbers(l1, l2)));
    }
}