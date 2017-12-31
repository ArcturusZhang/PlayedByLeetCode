import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode reverseBetween(ListNode head, int m, int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5]");
        System.out.println(solution.reverseBetween(head, 1, 3).asList());
    }
}
