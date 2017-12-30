import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode swapPairs(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(ListNode.toString(solution.swapPairs(ListNode.parse("[1, 2, 3, 4]"))));
        System.out.println(ListNode.toString(solution.swapPairs(ListNode.parse("[1, 2, 3, 4, 5]"))));
    }
}
