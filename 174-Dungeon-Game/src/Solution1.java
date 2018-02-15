import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 动态规划。
     * 从右下角开始反推进入每一个格子前的最低生命值
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param dungeon
     * @return
     */
    @Override
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        dungeon[rows - 1][cols - 1] = 1 - (dungeon[rows - 1][cols - 1] >= 0 ? 0 : dungeon[rows - 1][cols - 1]);
        // 最下一行
        for (int col = cols - 2; col >= 0; col--) {
            dungeon[rows - 1][col] = dungeon[rows - 1][col + 1] - dungeon[rows - 1][col];
            if (dungeon[rows - 1][col] <= 0) dungeon[rows - 1][col] = 1;
        }
        // 最右一列
        for (int row = rows - 2; row >= 0; row--) {
            dungeon[row][cols - 1] = dungeon[row + 1][cols - 1] - dungeon[row][cols - 1];
            if (dungeon[row][cols - 1] <= 0) dungeon[row][cols - 1] = 1;
        }
        // 其余部分
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                dungeon[row][col] = Math.min(dungeon[row + 1][col], dungeon[row][col + 1]) - dungeon[row][col];
                if (dungeon[row][col] <= 0) dungeon[row][col] = 1;
            }
        }
        for (int[] line : dungeon) {
            System.out.println(Arrays.toString(line));
        }
        return dungeon[0][0];
    }
}
