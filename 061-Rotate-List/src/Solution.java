import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode rotateRight(ListNode head, int k);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 1).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 2).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 3).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 4).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 5).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 6).asList());
        System.out.println(solution.rotateRight(ListNode.parse("[1, 2, 3, 4, 5]"), 7).asList());
    }
}
