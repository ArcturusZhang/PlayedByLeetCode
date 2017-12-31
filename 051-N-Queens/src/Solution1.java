import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/n-queens/description/</url>
     * 解：
     * 回溯法。
     * @param n
     * @return
     */
    @Override
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) { // 布置棋盘，以方便回溯和产生解
            Arrays.fill(board[i], '.');
        }
        nQueensCore(board, 0, result); // 启动回溯法
        return result;
    }

    private void nQueensCore(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) { // 出口
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
        } else {
            for (int j = 0; j < board.length; j++) {
                if (row == 0) {
                    board[row][j] = 'Q'; // 如果是第一行，则直接在第i列填入Queen
                } else { // 如果不是第一行，则需要遍历查看当前位置是否还可以填写Queen
                    if (isValid(board, row, j)) board[row][j] = 'Q';
                    else continue;  // 这一行保证了错解不会进入result。
                                    // 因为result需要row==n才会加入result，这一行使得错解无法执行下面的语句，从而保证了错解不会进入解答
                }
                nQueensCore(board, row + 1, result); // 递归填写下一行
                board[row][j] = '.'; // 回溯
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
