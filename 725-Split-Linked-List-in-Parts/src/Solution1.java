import arcturus.util.ListNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：将一个链表{@code root}尽量均匀的分为{@code k}个短链表，各个短链表之间的长度差别不超过1
     * 解：
     * 简单的链表题目。先获得链表的长度，以确定每一份的长度。由于要求长度尽量均匀，所以每个短链表的长度应该为length / k + 1或0，
     * 其中+1还是+0由length / k的余数决定
     * @param root
     * @param k
     * @return
     */
    @Override
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) return result;
        int length = 0;
        // 先获得链表长度
        for (ListNode node = root; node != null; node = node.next) length++;
        int piece = length / k, remainder = length % k;
        ListNode node = root, last = null;
        // 分拣过程
        for (int i = 0; i < k && node != null; i++, remainder--) {
            result[i] = node;
            for (int count = 0; count < piece + (remainder > 0 ? 1 : 0) && node != null; count++) {
                last = node;
                node = node.next;
            }
            last.next = null;
        }
        return result;
    }
}
