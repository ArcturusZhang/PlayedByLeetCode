import java.util.HashMap;
import java.util.Map;

public class Solution2 extends Solution {
    /**
     * 解：
     * 利用一个HashMap储存(原节点, 复制节点)对，即可方便的构造出复制链表。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    @Override
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            // 设置next
            map.get(node).next = map.get(node.next);
            // 设置random
            map.get(node).random = map.get(node.random); // 这里利用了HashMap当key为null时也返回null
            node = node.next;
        }
        return map.get(head);
    }
}
