import java.util.HashSet;
import java.util.Set;

public class Solution1 extends Solution {
    /**
     * 检验数独是否合法，但不要求其有解。
     * 很简单，将行遍历一次，列遍历一次，再遍历一次所有的3x3格子
     * @param board
     * @return
     */
    @Override
    public boolean isValidSudoku(char[][] board) {
        // 检验行
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !set.add(board[row][col])) return false;
            }
        }
        // 检验列
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.' && !set.add(board[row][col])) return false;
            }
        }
        // 检验3x3小格子
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[row + i][col + j] != '.' && !set.add(board[row + i][col + j])) return false;
                    }
                }
            }
        }
        return true;
    }
}
