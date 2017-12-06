import arcturus.util.ListNode;

public class Solution {
    /**
     * 简单的链表题目。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode node = head;
        ListNode last = null;
        while (node != null) {
            if (last != null && node.val == last.val) {
                last.next = node.next;
            } else {
                last = node;
            }
            node = node.next;
        }
        return phead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(ListNode.toString(solution.deleteDuplicates(ListNode.parse("[1, 1, 2, 2, 3]"))));
    }
}
