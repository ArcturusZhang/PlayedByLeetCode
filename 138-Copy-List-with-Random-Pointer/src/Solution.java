public abstract class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/copy-list-with-random-pointer/description/</url>
     * @param head
     * @return
     */
    public abstract RandomListNode copyRandomList(RandomListNode head);

    protected static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 由于此题的测试用例构造起来有些复杂，也没有配套的方法（因为这个类基本上只在这个题目中出现了），所以这里就不放测试用例了。
     * @param args
     */
    public static void main(String[] args) {
//        testCases(new Solution1());
    }

//    private static void testCases(Solution solution) {
//    }
}
