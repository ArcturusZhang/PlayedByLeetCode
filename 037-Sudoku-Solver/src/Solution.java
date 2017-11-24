import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 回溯法。具体请看代码中注释。
     * @param board
     */
    public void solveSudoku(char[][] board) {
        Set<String> constraint = new HashSet<>();
        // 遍历棋盘，将已有的数字作为约束输入。行、列和3x3格子的约束以不同格式的字符串存入约束集合。
        // 数字4在第i行：i(4)
        // 数字4在第j列：(4)j
        // 数字4在3x3格子x=row/3,y=col/3中：x(4)y
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String c = "(" + board[row][col] + ")";
                if (board[row][col] != '.') {
                    constraint.add(row + c);
                    constraint.add(c + col);
                    constraint.add((row / 3) + c + (col / 3));
                }
            }
        }
        // 从左上角开始遍历棋盘
        solver(board, 0, 0, constraint);
    }

    private boolean solver(char[][] board, int row, int col, Set<String> constraint) {
        if (row == 9) return solver(board, 0, col + 1, constraint);
        if (row == 0 && col == 9) return true; // 出口
        if (board[row][col] == '.') { // 需要填的数字
            for (int digit = 1; digit <= 9; digit++) {
                String c = "(" + digit + ")";
                if (!constraint.contains(row + c) && !constraint.contains(c + col)
                        && !constraint.contains((row / 3) + c + (col / 3))) {
                    board[row][col] = (char)(digit + '0');
                    constraint.add(row + c);
                    constraint.add(c + col);
                    constraint.add((row / 3) + c + (col / 3));
                    boolean result = solver(board, row + 1, col, constraint);
                    if (result) return true;
                    // 尝试失败，进行回溯
                    board[row][col] = '.';
                    constraint.remove(row + c);
                    constraint.remove(c + col);
                    constraint.remove((row / 3) + c + (col / 3));
                }
            }
        } else { // 已有数字
            return solver(board, row + 1, col, constraint);
        }
        return false;
    }

    /**
     * 这是036题目的解，在此处用来验证数独的求解是否正确。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> constraint = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c != '.') {
                    if (!constraint.add(row + "(" + c + ")") || !constraint.add("(" + c + ")" + col)
                            || !constraint.add((row / 3) + "(" + c + ")" + (col / 3))) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][] {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        solution.solveSudoku(board);
        for (int row = 0; row < 9; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
        System.out.println(solution.isValidSudoku(board));
    }
}
