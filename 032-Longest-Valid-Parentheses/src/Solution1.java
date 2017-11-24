import java.util.Stack;

public class Solution1 {
    /**
     * 解：
     * 用栈的实现
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int last = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else { // 右括号的情形
                if (stack.isEmpty()) {
                    last = i + 1;
                } else {
                    // 配对（因为栈中只有左括号，所以只要栈非空一定弹出元素和当前元素配对
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - last + 1);
                    else max = Math.max(max, i - stack.peek());
                    // 如果栈非空，说明有连续的左括号，所以直接用当前索引i减去栈顶（即减去配对左括号左边的那个左括号的索引，就是现在的长度）
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println("Solution1: ");
        System.out.println(solution1.longestValidParentheses(")()())"));
        System.out.println(solution1.longestValidParentheses("(()())"));
        System.out.println(solution1.longestValidParentheses(")()()"));
        System.out.println(solution1.longestValidParentheses(")()"));
        System.out.println(solution1.longestValidParentheses("((((()"));
        System.out.println(solution1.longestValidParentheses("((()"));
        Solution2 solution2 = new Solution2();
        System.out.println("Solution2: ");
        System.out.println(solution2.longestValidParentheses(")()())"));
        System.out.println(solution2.longestValidParentheses("(()())"));
        System.out.println(solution2.longestValidParentheses(")()()"));
        System.out.println(solution2.longestValidParentheses(")()"));
        System.out.println(solution2.longestValidParentheses("((((()"));
        System.out.println(solution2.longestValidParentheses("((()"));
    }
}
