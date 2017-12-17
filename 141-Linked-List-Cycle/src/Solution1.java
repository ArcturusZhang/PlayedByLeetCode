import arcturus.util.ListNode;

public class Solution1 {
    /**
     * 题目描述：判定一个单向链表中是否有环
     * 解：
     * 双指针法，一个快指针，一个慢指针。快指针每次向前走两个节点，慢指针每次只向前走一个节点。
     * 用这种方法判定链表是否有环的原理类似于两个跑步速度不同的人在跑道上跑步，如果跑道是环形的，则必然两个人会有相遇的时候。
     * 如果跑道是线性的，则永远不可能相遇。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5]");
        System.out.println(head.hasCycle());
        System.out.println(solution1.hasCycle(head));
        System.out.println(solution2.hasCycle(head));
        head.last().next = head.after(2);
        System.out.println(head.hasCycle());
        System.out.println(solution1.hasCycle(head));
        System.out.println(solution2.hasCycle(head));
    }
}
