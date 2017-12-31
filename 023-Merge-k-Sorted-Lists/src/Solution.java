import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode mergeKLists(ListNode[] lists);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode[] lists = new ListNode[]{
                ListNode.parse("[4, 7, 10, 92]"),
                ListNode.parse("[1, 2, 9, 37, 82, 100]"),
                ListNode.parse("[11, 12, 89, 1000]")
        };
        System.out.println(ListNode.toString(solution.mergeKLists(lists)));
    }
}
