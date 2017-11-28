package arcturus.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode parse(String string) {
        String[] nums = string.replace("[", "").replace("]", "").split(",");
        ListNode phead = new ListNode(0);
        ListNode last = phead;
        for (String numStr : nums) {
            last.next = new ListNode(Integer.valueOf(numStr.trim()));
            last = last.next;
        }
        return phead.next;
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
