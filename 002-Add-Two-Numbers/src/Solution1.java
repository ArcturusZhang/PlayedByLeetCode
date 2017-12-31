import arcturus.util.*;
public class Solution1 extends Solution {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode phead = new ListNode(0);
        ListNode last = phead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int digit = carry;
            if (l1 != null) {
                digit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digit += l2.val;
                l2 = l2.next;
            }
            carry = digit / 10;
            last.next = new ListNode(digit % 10);
            last = last.next;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return phead.next;
    }
}