import java.util.List;

public abstract class Solution {
    public abstract List<List<String>> partition(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.partition("aab"));
    }
}
