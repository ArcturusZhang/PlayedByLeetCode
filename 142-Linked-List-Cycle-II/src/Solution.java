import arcturus.util.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    slow = slow.next;
                    node = node.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5]");
        System.out.println(head.hasCycle());
        System.out.println(solution.detectCycle(head));
        head.last().next = head.after(2);
        System.out.println(head.hasCycle());
        System.out.println(solution.detectCycle(head));
        head = ListNode.parse("[0, 1]");
        head.last().next = head;
        System.out.println(solution.detectCycle(head));

    }
}
