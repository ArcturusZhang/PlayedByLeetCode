import java.util.Arrays;

public class Solution1 extends Solution {
    private int total;

    /**
     * 题目描述：<url>https://leetcode.com/problems/n-queens-ii/description/</url>
     * 解：
     * 回溯法，与051几乎相同，不需要输出解的形式反而简单了。
     * @param n
     * @return
     */
    @Override
    public int totalNQueens(int n) {
        total = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        } // 初始化棋盘
        queensCore(board, 0); // 启动回溯法
        return total;
    }

    private void queensCore(char[][] board, int row) {
        if (row == board.length) {
            total++; // 回溯法出口
        } else {
            for (int col = 0; col < board.length; col++) { // 对本行的每一列进行尝试
                if (row == 0) {
                    board[row][col] = 'Q'; // 第一行则每一列都可以尝试
                } else {
                    if (isValid(board, row, col)) board[row][col] = 'Q'; // 非第一列则需要验证此处是否可以放置Queen
                    else continue; // 如果不行直接跳下一循环
                }
                queensCore(board, row + 1); // 递归填写下一行
                board[row][col] = '.'; // 进行回溯
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') return false;
            if (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q') return false;
        }
        return true;
    }
}
