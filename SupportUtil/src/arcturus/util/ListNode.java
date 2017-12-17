package arcturus.util;

/**
 * 一个自制的单向链表类
 */
public class ListNode {
    public static final String SEPARATOR = ", ";
    public int val;
    public ListNode next;

    /**
     * 单向链表节点的构造器。
     * 如果需要构造单向链表，请使用{@code ListNode.parse}方法。
     * @param val 链表节点的值
     * @see ListNode#parse(String)
     * @see ListNode#parse(String, String)
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 读取输入的字符串，利用默认的分隔符，将其转换为一个单向链表。
     * @param data 输入的数据
     * @return 转换的单向链表
     */
    public static ListNode parse(String data) {
        return parse(data, SEPARATOR);
    }

    /**
     * 读取输入的字符串，利用给定的分隔符，将其转换为一个单向链表。
     * @param data 输入的数据
     * @param separator 输入的分隔符
     * @return 转换的单向链表
     */
    public static ListNode parse(String data, String separator) {
        String[] nums = data.replace("[", "").replace("]", "").split(separator);
        ListNode phead = new ListNode(0);
        ListNode last = phead;
        try {
            for (String numStr : nums) {
                last.next = new ListNode(Integer.valueOf(numStr.trim()));
                last = last.next;
            }
        } catch (Exception e) {
            throw new FormatException(e);
        }
        return phead.next;
    }

    /**
     * 用双指针方法判定链表中是否含有环
     * @return 有环时，返回{@code true}，否则返回{@code false}
     */
    public boolean hasCycle() {
        ListNode fast = this.next, slow = this;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 获得当前节点后的第{@code count}个节点。
     * @param count 节点数
     * @return 此节点后的第count个节点
     */
    public ListNode after(int count) {
        ListNode node = this;
        while (node != null && count > 0) {
            node = node.next;
            count--;
        }
        return node;
    }

    /**
     * 返回链表的最后一个节点
     * @return 链表的最后一个节点
     * @throws CyclicListException 当链表中有环时抛出异常
     */
    public ListNode last() throws CyclicListException {
        if (this.hasCycle()) throw new CyclicListException();
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 判定给定链表是否与本链表相同。
     * @param head 给定链表
     * @return 如果两链表相同，返回{@code true}，否则返回{@code false}
     * @throws CyclicListException 当当前链表或给定链表中有环时抛出异常
     */
    public boolean isSameList(ListNode head) throws CyclicListException {
        if (head == null) return false;
        ListNode node = this;
        if (node.hasCycle() || head.hasCycle()) throw new CyclicListException();
        while (node != null && head != null) {
            if (node.val != head.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 将一个链表转化为字符串
     * @param node 链表的头指针
     * @return 转换结果
     * @throws FormatException 当数字转换失败时抛出异常
     * @throws CyclicListException 当链表中有环时抛出异常
     */
    public static String toString(ListNode node) throws FormatException, CyclicListException {
        if (node.hasCycle()) throw new CyclicListException();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            while (node != null) {
                sb.append(node.val);
                if (node.next != null) sb.append(SEPARATOR);
                node = node.next;
            }
        } catch (Exception e) {
            throw new FormatException(e);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ListNode : val = " + this.val;
    }
}
