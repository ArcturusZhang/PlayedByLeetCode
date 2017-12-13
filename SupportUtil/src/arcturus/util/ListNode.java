package arcturus.util;

public class ListNode {
    private static final String separator = ", ";
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode parse(String data) {
        return parse(data, separator);
    }

    public static ListNode parse(String data, String seperator) {
        String[] nums = data.replace("[", "").replace("]", "").split(seperator);
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

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(separator);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
