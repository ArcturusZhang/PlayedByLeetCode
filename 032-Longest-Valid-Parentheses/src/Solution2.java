public class Solution2 extends Solution {
    /**
     * 解：
     * 利用动态规划。记longest[i]为以字符i为结尾的最长合法括号序列的长度。那么有如下的递推关系：
     * 1. 如果字符i是左括号'('，那么longest[i] = 0，因为合法括号序列不能以左括号结尾。
     * 2. 如果字符i是右括号')'，那么需要分下面几种情况：
     *    (1) 如果字符i-1是左括号'('，那么longest[i] = 2 + longest[i - 2]（如果越界，那么越界的部分视作0）
     *    (2) 如果字符i-1是右括号')'，那么需要确定与右括号i-1配对的那个左括号左边的字符是不是左括号。
     *        与右括号i-1配对的左括号的索引为i - longest[i-1]，所以需要再分下面两种情况：
     *        (a) 字符i - longest[i-1] - 1是左括号，则longest[i] = longest[i-1] + 2 + longest[i - longest[i-1] - 2]
     *        (b) 字符i - longest[i-1] - 1不是左括号，则longest[i] = 0
     *    (3) 其余未提到的情况都有longest[i] = 0
     * 在上面的过程中，额外维护一个变量储存最大值，最后返回最大值即可。
     * @param s
     * @return
     */
    @Override
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int[] longest = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') longest[i] = 0;
            else {
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    longest[i] = i - 2 >= 0 ? 2 + longest[i - 2] : 2;
                } else if (i - 1 >= 0 && s.charAt(i - 1) == ')') {
                    if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                        longest[i] = i - longest[i - 1] - 2 >= 0 ? longest[i - 1] + 2 + longest[i - longest[i - 1] - 2]
                                : longest[i - 1] + 2;
                    }
                }
                if (longest[i] > max) max = longest[i];
            }
        }
        return max;
    }
}
