import arcturus.util.ArrayUtils;

import java.util.List;

public abstract class Solution {
    public abstract List<String> findWords(char[][] board, String[] words);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] board = ArrayUtils.gridConstructor("oaan, etae, ihkr, iflv");
        System.out.println(solution.findWords(board, new String[] {"oath","pea","eat","rain"}));
    }
}
