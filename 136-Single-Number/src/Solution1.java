import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    /**
     * 利用集合，当元素重复出现时，将其从集合中移除，这样遍历到数组结尾时，集合中只剩下一个元素，就是这个单独的数字。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) { // 如果add返回false说明这个数字第二次出现
                set.remove(num);
            }
        }
        return new ArrayList<>(set).get(0);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.singleNumber(new int[] {1, 3, 3, 2, 2, 6, 7, 6, 7}));
    }
}
