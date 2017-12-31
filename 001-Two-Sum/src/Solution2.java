import java.util.HashMap;
import java.util.Map;

public class Solution2 extends Solution {
    /**
     * 利用{@code HashMap}
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                if (index != i) return new int[] {i, index};
            }
        }
        return null;
    }
}
