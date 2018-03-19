public class Solution1 extends Solution {
    int area = 0;
    @Override
    public int maxAreaOfIsland(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int max = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    area = 0;
                    explore(grid, rows, cols, row, col);
                    if (area > max) max = area;
                }
            }
        }
        return max;
    }

    private void explore(char[][] grid, int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1') return;
        grid[row][col] = '*';
        area++;
        explore(grid, rows, cols, row + 1, col);
        explore(grid, rows, cols, row - 1, col);
        explore(grid, rows, cols, row, col + 1);
        explore(grid, rows, cols, row, col - 1);
    }
}
