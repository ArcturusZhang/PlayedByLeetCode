import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    public abstract int ladderLength(String beginWord, String endWord, List<String> wordList);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(solution.ladderLength("hot", "dog", new ArrayList<>(Arrays.asList("hot", "dog"))));
    }
}
