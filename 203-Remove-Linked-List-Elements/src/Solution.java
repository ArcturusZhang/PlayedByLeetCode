import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode removeElements(ListNode head, int val);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 6, 3, 4, 5, 6]");
        System.out.println(solution.removeElements(head, 6).asList());
//        System.out.println(solution.removeElements(head, 1).asList());
    }
}
