import java.util.List;

public abstract class Solution {
    public abstract List<String> generateParenthesis(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        for (int i = 0; i < 8; i++) {
            System.out.println(solution.generateParenthesis(i));
        }
    }
}
