public class Solution1 extends Solution {
    /**
     * 解：
     * 深度优先搜索。解法中的visited数组实际上是非必要的，也可以直接修改grid的内容，将探索过的地块改为0即可。
     * @param grid
     * @return
     */
    @Override
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    explore(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void explore(char[][] grid, boolean[][] visited, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && !visited[row][col] && grid[row][col] == '1') {
            visited[row][col] = true;
            explore(grid, visited, row + 1, col);
            explore(grid, visited, row - 1, col);
            explore(grid, visited, row, col + 1);
            explore(grid, visited, row, col - 1);
        }
    }
}
