import arcturus.util.ListNode;

public class Solution {
    /**
     * 简单的归并排序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode phead = new ListNode(0);
        ListNode node = phead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null) l1 = l2;
        while (l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        return phead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.parse("[1,3,5,6]");
        ListNode l2 = ListNode.parse("[0,2,90]");
        System.out.println(ListNode.toString(solution.mergeTwoLists(l1, l2)));
    }
}
