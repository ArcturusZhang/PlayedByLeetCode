import java.util.HashSet;
import java.util.Set;

public class Solution1 extends Solution {
    /**
     * 利用两个HashSet记录零元素的行号和列号，全部扫描一遍之后再分别将需要的行和列置零。
     * 时间复杂度：O(MN)
     * 空间复杂度：O(M+N)
     * @param matrix
     */
    @Override
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        // 记录为零的点的行号和列号
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // 根据得到的行号将相应行置零
        for (int row : rowSet) {
            for (int j = 0; j < cols; j++) {
                matrix[row][j] = 0;
            }
        }
        // 根据得到的列号将相应列置零
        for (int col : colSet) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
