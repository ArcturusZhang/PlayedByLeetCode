import arcturus.util.ListNode;

import java.util.PriorityQueue;

public class Solution1 extends Solution {
    /**
     * 题目描述：
     * 与前面021题类似，只不过这次是要合并k个排序链表。
     * 解：
     * 在合并两个排序链表的程序中，每次取出两个链表中较小的，链接在新链表节点后即可。
     * 本题思路完全相同，每次找出k个链表中当前指向元素中最小的，链接在新链表节点后。取最小如果直接采用完整遍历的方式，
     * 一是会遇到链表长度不同时，产生null的问题，二是效率较低。所以这里取最小采用优先队列的方式实现。
     * 优先队列的本质是排序，性能也能得到保障。
     * @param lists
     * @return
     */
    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode phead = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode node1, ListNode node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        ListNode node = phead;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll(); // 取出最小元素
            node.next = min;
            if (min.next != null) queue.add(min.next);
            node = node.next;
        }
        return phead.next;
    }
}
