public abstract class Solution {
    public abstract boolean exist(char[][] board, String word);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(solution.exist(board, "CESEECF"));
        System.out.println(solution.exist(new char[][] {{'a', 'a'}}, "aaa"));
    }
}
