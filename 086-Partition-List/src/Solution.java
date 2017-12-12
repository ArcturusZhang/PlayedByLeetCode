import arcturus.util.ListNode;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/partition-list/description/</url>
     * 解：
     * 比较简单的链表题目。特别需要注意不要让链表成环（即链表修改之后，一定要让尾节点.next = null）。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode phead1 = new ListNode(0); // 记录小于x的列表
        ListNode phead2 = new ListNode(0); // 记录大于等于x的列表
        ListNode node1 = phead1, node2 = phead2, node = head;
        while (node != null) {
            if (node.val < x) {
                node1.next = node;
                node1 = node1.next;
            } else {
                node2.next = node;
                node2 = node2.next;
            }
            node = node.next;
        }
        node1.next = phead2.next;
        node2.next = null; // 防止成环
        return phead1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.parse("[1, 4, 3, 2, 5, 2]");
        System.out.println(ListNode.toString(solution.partition(head, 5)));
    }
}
