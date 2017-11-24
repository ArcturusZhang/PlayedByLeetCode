import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    /**
     * LeetCode讨论区中一个人的思路，只需要一个HashSet即可。
     * 思路：
     * 对格子中的数字和分布编码为String，例如：
     * 数字4在第i行，编码为：i(4)
     * 数字4在第j列，编码为：(4)j
     * 数字4在中间3x3格子，编码为：1(4)1（注：格子的编号可以通过i/3, j/3得到）
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c != '.') {
                    if (!set.add(row + "(" + c + ")") || !set.add("(" + c + ")" + col)
                            || !set.add((row / 3) + "(" + c + ")" + (col / 3))) return false;
                }
            }
        }
        return true;
    }
}
