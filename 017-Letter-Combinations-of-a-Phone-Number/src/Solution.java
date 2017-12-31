import java.util.List;

public abstract class Solution {
    public abstract List<String> letterCombinations(String digits);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("123"));
        System.out.println(solution.letterCombinations("213"));
    }
}
