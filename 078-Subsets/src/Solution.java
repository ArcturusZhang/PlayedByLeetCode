import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：获得指定数组的所有子集的集合（幂集）
     * 解：
     * 回溯法。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // 空集提前加入作为特殊处理
        if (nums == null || nums.length == 0) return result;
        subsetsCore(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void subsetsCore(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]); // 将当前数字加入
                result.add(new ArrayList<>(current)); // 将当前结果加入
                subsetsCore(nums, i + 1, result, current); // 递归加入下一个数字
                current.remove(current.size() - 1); // 进行回溯
            }
        } // 回溯出口
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }
}
