import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode addTwoNumbers(ListNode l1, ListNode l2);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode l1 = ListNode.parse("[2, 4, 3]");
        ListNode l2 = ListNode.parse("[5, 6, 4]");
        System.out.println(l1.asList() + " + " + l2.asList() + " = " + solution.addTwoNumbers(l1, l2).asList());
    }
}
