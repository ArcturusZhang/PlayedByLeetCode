public class Solution1 extends Solution {
    /**
     * 解：
     * 基本思路：假设原链表为A->B->C，将每个节点先复制一份，链接在原链表中原节点的后面，即将原链表转化为：
     * A->A'->B->B'->C->C'
     * 然后进行第二趟遍历，将复制节点的random指针指向相应的复制节点（即原指针random的next）
     * 最后进行第三趟遍历，将复制节点与原节点作为两个链表拆开。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    @Override
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        // 第一趟遍历：将每个节点复制一份，接在原节点的的后面
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        // 第二趟遍历：将每个复制节点的random指针指向应该指向的元素
        node = head;
        while (node != null) {
            RandomListNode copy = node.next;
            if (node.random != null) copy.random = node.random.next;
            node = node.next.next;
        }
        // 第三趟遍历：将原链表和复制链表分离
        node = head;
        RandomListNode phead = new RandomListNode(0), pnode = phead;
        while (node != null) {
            RandomListNode copy = node.next;
            pnode.next = copy;
            pnode = pnode.next;
            node.next = copy.next;
            node = node.next;
        }
        return phead.next;
    }
}
