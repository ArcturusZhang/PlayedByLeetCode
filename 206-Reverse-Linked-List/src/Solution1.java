import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 解：
     * 假设链表表示为1->2->3->4
     * 遍历一次，遍历的过程中将箭头全部反向即可。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    @Override
    public ListNode reverseList(ListNode head) {
        ListNode last = null, node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        return last;
    }
}
