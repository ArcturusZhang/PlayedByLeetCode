import java.util.Stack;

public class Solution {
    /**
     * 题目描述：
     * 给出一个由括号（左右小括号、中括号、大括号）构成的字符串，检验其中的括号是否合法配对
     * 解：
     * 检验表达式是否合法，利用栈。从左到右扫描字符串，当遇到一个左括号时，将其入栈。
     * 当遇到一个右括号时，弹出栈顶元素（如果栈为空则返回false），检验其是否与这个右括号配对。如果不能配对，返回false。
     * 重复上面的过程，直到扫描至最后一个字符。最后检查栈是否为空，如果为空，说明表达式合法。如果非空，说明表达式非法。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 如果是左括号，则入栈
                stack.push(c);
            } else {
                // 右括号则出栈一个字符，检查是否配对
                if (stack.isEmpty()) return false; // 栈为空
                char left = stack.pop();
                if (!isPair(left, c)) return false; // 不配对
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char left, char right) {
        if (left == '(') return right == ')';
        if (left == '[') return right == ']';
        if (left == '{') return right == '}';
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(({{}}()[]))"));
        System.out.println(solution.isValid("(("));
        System.out.println(solution.isValid("(()]]"));
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("]"));
    }
}
