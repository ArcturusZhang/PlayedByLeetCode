import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 extends Solution {
    /**
     * 回溯法（DFS）
     * 由于words中可能包含重复单词，所以此处使用HashSet去重
     * @param board
     * @param words
     * @return
     */
    @Override
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        if (words == null || words.length == 0) return new ArrayList<>();
        int rows = board.length, cols = board[0].length;
        Set<String> result = new HashSet<>();
        for (String word : words) {
            if (wordExists(board, word, rows, cols)) {
                result.add(word);
            }
        }
        return new ArrayList<>(result);
    }

    private boolean wordExists(char[][] board, String word, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] flag = new boolean[rows][cols];
                    boolean result = explore(board, flag, rows, cols, row, col, word, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean explore(char[][] board, boolean[][] flag, int rows, int cols, int row, int col, String word, int idx) {
        if (idx == word.length()) return true; // 回溯出口
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false; // 回溯出口
        if (flag[row][col] || board[row][col] != word.charAt(idx)) return false; // 回溯出口
        boolean result;
        flag[row][col] = true;
        result = explore(board, flag, rows, cols, row - 1, col, word, idx + 1); // 向上
        if (result) return true;
        result = explore(board, flag, rows, cols, row + 1, col, word, idx + 1); // 向下
        if (result) return true;
        result = explore(board, flag, rows, cols, row, col - 1, word, idx + 1); // 向左
        if (result) return true;
        result = explore(board, flag, rows, cols, row, col + 1, word, idx + 1); // 向右
        if (result) return true;
        flag[row][col] = false; // 回溯
        return false;
    }
}
