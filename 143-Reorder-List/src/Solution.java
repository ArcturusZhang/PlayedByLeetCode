import arcturus.util.ListNode;

public abstract class Solution {
    public abstract void reorderList(ListNode head);

    public static void main(String[] args) {
//        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head;
        head = ListNode.parse("[1, 2, 3, 4, 5]");
        solution.reorderList(head);
        System.out.println(head.hasCycle());
        System.out.println(head.asList());
        head = ListNode.parse("[1, 2, 3, 4]");
        solution.reorderList(head);
        System.out.println(head.asList());
    }
}
