import arcturus.util.ListNode;

public abstract class Solution {
    public abstract void deleteNode(ListNode node);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 3, 4]");
        solution.deleteNode(head.after(2));
        System.out.println(head.asList());
    }
}
