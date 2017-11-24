import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 回溯法
     * @param board
     */
    public void solveSudoku(char[][] board) {
        Set<String> constraint = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                String string = "(" + c + ")";
                if (c != '.') {
                    constraint.add(row + string);
                    constraint.add(string + col);
                    constraint.add((row / 3) + string + (col / 3));
                }
            }
        }
    }

    private void solver(char[][] board, Set<String> constraint) {

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
        System.out.println(solution.isValidSudoku(board));
    }
}
