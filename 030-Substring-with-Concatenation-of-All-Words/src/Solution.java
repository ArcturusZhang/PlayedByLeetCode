import java.util.List;

public abstract class Solution {
    public abstract List<Integer> findSubstring(String s, String[] words);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
    }
}
