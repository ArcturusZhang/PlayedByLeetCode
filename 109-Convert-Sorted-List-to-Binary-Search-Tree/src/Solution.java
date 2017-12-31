import arcturus.util.ListNode;
import arcturus.util.TreeNode;

public abstract class Solution {
    public abstract TreeNode sortedListToBST(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5, 6, 10]");
        System.out.println(solution.sortedListToBST(head).asList());
        head = ListNode.parse("[1, 2, 3, 4]");
        System.out.println(solution.sortedListToBST(head).asList());
        System.out.println(solution.sortedListToBST(ListNode.parse("[1]")).asList());
    }
}
