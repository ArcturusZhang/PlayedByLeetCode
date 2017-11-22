import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：
     * 给定整数n，生成由n对括号构成的，所有合法的括号表达式。
     * 解：
     * 利用动态规划，例如将i对括号形成的括号表达式记作f_i，则f_i+1可以利用前面的表达式写作
     * (f_i)f_0, (f_i-1)f_1, (f_i-2)f_2, ... , (f_2)f_i-2, (f_1)f_i-1, (f_0)f_i
     * 其中边界条件为：f_0 = ""（空字符串）。例如：f_1 = ()，它可以表示为(f_0)f_0
     * f_2 = (()), ()()，它可以表示为(f_1)f_0, (f_0)f_1，以此类推
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> results = new ArrayList<>(n + 1);
        List<String> result = new ArrayList<>();
        result.add("");
        if (n == 0) return result;
        results.add(result);
        for (int i = 1; i <= n; i++) {
            result = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> sub1 = results.get(j);
                List<String> sub2 = results.get(i - 1 - j);
                for (String str1 : sub1) {
                    for (String str2 : sub2) {
                        result.add("(" + str1 + ")" + str2);
                    }
                }
            }
            results.add(result);
        }
        return results.get(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 8; i++) {
            System.out.println(solution.generateParenthesis(i));
        }
    }
}
