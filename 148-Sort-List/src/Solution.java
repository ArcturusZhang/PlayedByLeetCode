import arcturus.util.ListNode;

public abstract class Solution {
    /**
     * 题目描述：使用O(N*log(N))的时间复杂度和常数空间复杂度排序一个单向链表。
     * @param head
     * @return
     */
    public abstract ListNode sortList(ListNode head);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.sortList(ListNode.parse("[1]")).asList());
        System.out.println(solution.sortList(ListNode.parse("[3, 2, 1]")).asList());
        System.out.println(solution.sortList(ListNode.parse("[3, 2, 7, 10, 6")).asList());
    }
}
