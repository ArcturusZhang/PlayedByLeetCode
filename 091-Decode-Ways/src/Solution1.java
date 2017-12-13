public class Solution1 {
    int ways;

    /**
     * 题目描述：<url>https://leetcode.com/problems/decode-ways/description/</url>
     * 解：（Time Limit Exceeded）
     * 回溯法。时间复杂度是指数级的。
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        ways = 0;
        decodingCore(s, 0);
        return ways;
    }

    private void decodingCore(String s, int start) {
        if (start < s.length() && s.charAt(start) != '0') { // 当前字符非零才进行，否则回溯
            // 一个字符的结果，由于已经排除了当前字符为零的情况，所以直接递归进行下一个字符的判定即可
            decodingCore(s, start + 1);
            // 两个字符的结果
            int two;
            if (start + 2 <= s.length() && (two = Integer.valueOf(s.substring(start, start + 2))) > 0 && two <= 26) {
                decodingCore(s, start + 2); // 两个字符组成的数字需要在1和26之间
            }
        } else if (start == s.length()) { // 回溯出口
            ways++;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        System.out.println(solution1.numDecodings("0"));
        System.out.println(solution1.numDecodings("10"));
        System.out.println(solution1.numDecodings("10545"));
        System.out.println(solution1.numDecodings("9035421"));
        System.out.println(solution1.numDecodings("820210"));
        System.out.println(solution1.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
        System.out.println(solution2.numDecodings("0"));
        System.out.println(solution2.numDecodings("10"));
        System.out.println(solution2.numDecodings("10545"));
        System.out.println(solution2.numDecodings("9035421"));
        System.out.println(solution2.numDecodings("820210"));
        System.out.println(solution2.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}
