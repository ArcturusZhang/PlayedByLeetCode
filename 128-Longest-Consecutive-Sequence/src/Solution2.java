import java.util.HashSet;
import java.util.Set;

public class Solution2 extends Solution {
    /**
     * 解：
     * 利用HashSet的存取时间都是O(1)的特性，每次遇到一个数字的时候，开始循环检查其-1是否在集合中存在（并移除），然后再循环检查其+1是否存在（并移除）
     * 同时维护一个变量记录最大的长度即可。
     * @param nums
     * @return
     */
    @Override
    public int longestConsecutive(int... nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 1;
        for (int num : nums) {
            if (set.remove(num)) { // set中包含num这个数字
                int val = num;
                while (set.remove(val - 1)) val--;
                int left = num - val;
                val = num;
                while (set.remove(val + 1)) val++;
                int right = val - num;
                longest = Math.max(longest, left + right + 1);
            }
        }
        return longest;
    }
}
