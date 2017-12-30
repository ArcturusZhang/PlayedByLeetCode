import arcturus.util.ListNode;

public abstract class Solution {
    public abstract ListNode[] splitListToParts(ListNode root, int k);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        ListNode root = ListNode.parse("[1, 2, 3, 4, 5, 6, 7]");
        ListNode[] list = solution.splitListToParts(root, 3);
        for (ListNode node : list) {
            System.out.println(ListNode.toString(node));
        }
    }
}
