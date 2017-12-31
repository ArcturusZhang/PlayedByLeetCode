import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode mergeTwoLists(ListNode l1, ListNode l2);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode l1 = ListNode.parse("[1, 3, 5, 6]");
        ListNode l2 = ListNode.parse("[0, 2, 90]");
        System.out.println(ListNode.toString(solution.mergeTwoLists(l1, l2)));
    }
}
