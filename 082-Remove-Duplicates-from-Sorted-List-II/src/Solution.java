import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode deleteDuplicates(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.deleteDuplicates(ListNode.parse("[1,1,1,2,3,3,5]", ",")).asList());
    }
}
