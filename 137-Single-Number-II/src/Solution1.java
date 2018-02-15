import java.util.HashMap;
import java.util.Map;

public class Solution1 extends Solution {
    /**
     * 利用哈希表的简单做法。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    @Override
    public int singleNumber(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) == 3) map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        return (int)map.keySet().toArray()[0];
    }
}
