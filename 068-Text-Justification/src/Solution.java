import java.util.List;

public abstract class Solution {
    public abstract List<String> fullJustify(String[] words, int maxWidth);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.fullJustify(new String[] {"This", "is", "justification.", "an", "example", "of", "text", "test"}, 16));
        System.out.println(solution.fullJustify(new String[] {"a"}, 1));
        System.out.println(solution.fullJustify(new String[] {"a", "b", "c", "d", "e"}, 3));
        System.out.println(solution.fullJustify(new String[] {"", ""}, 3));
    }
}
