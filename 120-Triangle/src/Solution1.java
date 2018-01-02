import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/triangle/description/</url>
     * 解：
     * 动态规划。建立一个形状与{@code triangle}相同的列表记作dp(i,j)，其中dp(i,j)表示从左上角到i,j位置的最小路径和。
     * 那么首先有边界条件 dp(0,0) = triangle(0,0)
     * 以及 dp(i+1,0) = dp(i,0) + triangle(i+1,0)，这是由于这个题目不允许选取上一行右侧的元素。
     * 转移方程为：
     * dp(i+1,j) = min(dp(i,j), dp(i,j-1)) + triangle(i+1,j)
     * 最后返回dp最后一行中最小的数字即可。
     * @param triangle
     * @return
     */
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(Arrays.asList(triangle.get(0).get(0))));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = new ArrayList<>(), last = dp.get(i - 1);
            List<Integer> currentLine = triangle.get(i);
            for (int j = 0; j < currentLine.size(); j++) {
                int min = Integer.MAX_VALUE;
                if (j < last.size()) min = Math.min(min, last.get(j));
                if (j - 1 >= 0) min = Math.min(min, last.get(j - 1));
//                if (j + 1 < last.size()) min = Math.min(min, last.get(j + 1)); // 题目的“相邻”竟然指的是上一行的当前位置或者左侧数字，右侧数字不算的
                current.add(currentLine.get(j) + min);
            }
            dp.add(current);
        }
        int min = dp.get(dp.size() - 1).get(0);
        for (int i = 1; i < dp.get(dp.size() - 1).size(); i++) {
            min = Math.min(min, dp.get(dp.size() - 1).get(i));
        }
        return min;
    }
}
