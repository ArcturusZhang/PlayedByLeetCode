import java.util.HashMap;
import java.util.Map;

public class Solution1 extends Solution {
    /**
     * 解：
     * 利用HashMap
     * @param nums
     * @return
     */
    @Override
    public int majorityElement(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int threhold = nums.length / 2 + nums.length % 2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) == threhold) return num;
        }
        return 0;
    }
}
