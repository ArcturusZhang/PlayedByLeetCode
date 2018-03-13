import arcturus.util.ListNode;

public abstract class Solution {
    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode[] heads = new ListNode[]{
                ListNode.parse("[1, 2, 3, 4, 3, 2, 1]"),
                ListNode.parse("[1, 2, 3, 3, 2, 1]"),
                ListNode.parse("[1, 2, 3, 4, 5, 3, 2, 1]"),
                ListNode.parse("[1, 2, 3, 4, 2, 1]")
        };
        for (ListNode head : heads)
            System.out.println(solution.isPalindrome(head));
    }

    public abstract boolean isPalindrome(ListNode head);
}
