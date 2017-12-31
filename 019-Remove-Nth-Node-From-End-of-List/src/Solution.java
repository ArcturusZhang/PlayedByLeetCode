import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode removeNthFromEnd(ListNode head, int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 0)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 1)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 2)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 3)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 4)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 5)));
        System.out.println(ListNode.toString(solution.removeNthFromEnd(ListNode.parse("[1, 2, 3, 4, 5]"), 6)));
    }
}
