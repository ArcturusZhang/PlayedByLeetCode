import arcturus.util.ListNode;
import arcturus.util.TreeNode;

public class Solution {
    /**
     * 题目描述：将排序链表转化为平衡二叉树
     * 解：
     * 与108题基本相同，区别在于链表无法方便的得到中间节点。一种方式是通过快慢双指针来获得中间节点。
     * 快指针每次向后两个节点，慢指针每次向后一个节点，当快指针到链表结尾时，慢指针指向的就是中点。
     * 以中点为界，将链表拆为两部分递归执行即可构建出平衡二叉树。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return listToBSTCore(head, null);
    }

    private TreeNode listToBSTCore(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode slow = head, fast = head;
        // 获得中间节点
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = listToBSTCore(head, slow);
        root.right = listToBSTCore(slow.next, end);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.parse("[1, 2, 3, 4, 5, 6, 10]");
        System.out.println(solution.sortedListToBST(head).asList());
        head = ListNode.parse("[1, 2, 3, 4]");
        System.out.println(solution.sortedListToBST(head).asList());
        System.out.println(solution.sortedListToBST(ListNode.parse("[1]")).asList());
    }
}
