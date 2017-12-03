public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/word-search/description/</url>
     * 解：
     * 回溯法。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols]; // 记录此格子是否访问过
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean result = existCore(board, visited, row, col, rows, cols, word, 0);
                if (result) return true;
            }
        }
        return false;
    }

    private boolean existCore(char[][] board, boolean[][] visited, int row, int col, int rows, int cols, String word, int idx) {
        if (idx == word.length()) {
            return true; // 回溯法出口
        } else {
            if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) return false; // 边界条件
            char c = word.charAt(idx);
            if (!visited[row][col] && board[row][col] == c) {
                visited[row][col] = true; // 标记此格子已被访问过
                boolean result = existCore(board, visited, row + 1, col, rows, cols, word, idx + 1)
                        || existCore(board, visited, row - 1, col, rows, cols, word, idx + 1)
                        || existCore(board, visited, row, col + 1, rows, cols, word, idx + 1)
                        || existCore(board, visited, row, col - 1, rows, cols, word, idx + 1);
                // 递归尝试所有相邻格子
                if (result) return true; // 如果找到单词则返回
                visited[row][col] = false; // 没有找到则回溯
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        Solution solution = new Solution();
//        System.out.println(solution.exist(board, "CESEECF"));
        System.out.println(solution.exist(new char[][] {{'a', 'a'}}, "aaa"));
    }
}
