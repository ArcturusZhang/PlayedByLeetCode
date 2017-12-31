import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 题目描述：生成帕斯卡三角。
     * 解：
     * 根据帕斯卡三角的递推关系很容易实现
     * @param numRows
     * @return
     */
    @Override
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;
        List<Integer> current = new ArrayList<>(), last;
        current.add(1);
        result.add(current);
        if (numRows == 1) return result;
        for (int row = 1; row < numRows; row++) {
            current = new ArrayList<>();
            last = result.get(row - 1);
            current.add(1);
            int i = 1;
            while (i < row) {
                current.add(last.get(i - 1) + last.get(i));
                i++;
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
