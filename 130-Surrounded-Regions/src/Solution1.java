public class Solution1 extends Solution {
    /**
     * 与第200题【Number of islands】类似。先利用DFS将与边缘相邻的区域标记为另外的符号（这里使用的是'P'），然后直接将所有剩下的O改成X即可
     * 剩下的这些O既然不与边缘相邻，就一定是被surround的。最后别忘了再把所有的P改回O
     * @param board
     */
    @Override
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length, cols = board[0].length;
        // 先将与边缘相邻的格子都改成O之外的字符
        // 第一行和最后一行
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') explore(board, rows, cols, 0, col, 'P');
            if (board[rows - 1][col] == 'O') explore(board, rows, cols, rows - 1, col, 'P');
        }
        // 第一列和最后一列
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') explore(board, rows, cols, row, 0, 'P');
            if (board[row][cols - 1] == 'O') explore(board, rows, cols, row, cols - 1, 'P');
        }
        // 然后将所有的O改成X，剩下的P改成O就可以了
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                else if (board[row][col] == 'P') board[row][col] = 'O';
            }
        }
    }

    private void explore(char[][] board, int rows, int cols, int row, int col, char mark) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        if (board[row][col] != 'O') return;
        board[row][col] = mark;
        explore(board, rows, cols, row + 1, col, mark);
        explore(board, rows, cols, row - 1, col, mark);
        explore(board, rows, cols, row, col + 1, mark);
        explore(board, rows, cols, row, col - 1, mark);
    }
}
