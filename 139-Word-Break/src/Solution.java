import java.util.List;

public abstract class Solution {
    public abstract boolean wordBreak(String s, List<String> wordDict);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
    }
}
