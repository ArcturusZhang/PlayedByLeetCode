import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode partition(ListNode head, int x);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.partition(ListNode.parse("[1, 4, 3, 2, 5, 2]"), 5).asList());
        System.out.println(solution.partition(ListNode.parse("[1, 4, 3, 2, 5, 2]"), 3).asList());
    }
}
