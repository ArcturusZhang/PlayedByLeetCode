import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 extends Solution {
    /**
     * 本题与073-Subsets基本相同，只是在最初数组中有重复数字时，结果可能也会生成相同的组合，需要将这些重复的排除掉。
     * 一种方法如下，在递归过程中检测当前数字是否已经加入进了集合中。
     * 另一种方法是利用集合{@code Set}类来删除重复解。
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        result.add(new ArrayList<>()); // 空集提前加入作为特殊处理
        subsetsCore(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void subsetsCore(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                if (i == start || nums[i - 1] != nums[i]) { // 防止生成重复的组合
                    current.add(nums[i]); // 将当前数字加入
                    result.add(new ArrayList<>(current)); // 将当前结果加入
                    subsetsCore(nums, i + 1, result, current); // 递归加入下一个数字
                    current.remove(current.size() - 1); // 进行回溯
                }
            }
        }
    }
}
