import arcturus.util.ListNode;

public abstract class Solution {
    public abstract boolean hasCycle(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5]");
//        System.out.println(head.hasCycle());
        System.out.println(solution.hasCycle(head));
        head.last().next = head.after(2);
//        System.out.println(head.hasCycle());
        System.out.println(solution.hasCycle(head));
    }
}
