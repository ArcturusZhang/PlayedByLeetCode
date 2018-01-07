import java.util.LinkedList;
import java.util.Queue;

public class Solution2 extends Solution {
    /**
     * 解：
     * 广度优先搜索。解法中的visited数组实际上是非必要的，也可以直接修改grid的内容，将探索过的地块改为0即可。
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
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.offer(i * cols + j);
                    while (!neighbors.isEmpty()) {
                        int neighbor = neighbors.poll();
                        int row = neighbor / cols, col = neighbor % cols;
                        if (row + 1 < rows && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                            neighbors.offer((row + 1) * cols + col);
                            visited[row + 1][col] = true;
                        }
                        if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                            neighbors.offer((row - 1) * cols + col);
                            visited[row - 1][col] = true;
                        }
                        if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                            neighbors.offer(row * cols + col - 1);
                            visited[row][col - 1] = true;
                        }
                        if (col + 1 < cols && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                            neighbors.offer(row * cols + col + 1);
                            visited[row][col + 1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
