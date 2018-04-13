import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    public abstract List<String> wordBreak(String s, List<String> wordDict);

    public static void main(String[] args) {
//        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        List<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(solution.wordBreak("catsanddog", dict));
    }
}
