import arcturus.util.ListNode;

public abstract class Solution {
    /**
     * 题目描述：将一个单向链表反转
     * @param head
     * @return
     */
    public abstract ListNode reverseList(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode head = ListNode.parse("[1, 2, 3, 4]");
        System.out.println(solution.reverseList(head).asList());
    }
}
