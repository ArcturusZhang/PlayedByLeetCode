import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 穷举
public abstract class Solution {
    public abstract int[] twoSum(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
