import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode getIntersectionNode(ListNode headA, ListNode headB);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode headA = ListNode.parse("[1, 2]");
        ListNode headB = ListNode.parse("[10, 11, 12]");
        ListNode common = ListNode.parse("[3, 4, 5]");
        headA.append(common);
        headB.append(common);
        System.out.println(solution.getIntersectionNode(headA, headB).asList());
    }
}
