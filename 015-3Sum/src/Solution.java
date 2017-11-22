import java.util.*;

public class Solution {
    /**
     * 题目描述：
     * 在给定数组中选出所有“三个数字之和为零”的组合，每个数字只能使用一次（但数组中可能有重复数字）
     * 解：
     * 暴力搜索是O(N^3)复杂度，所以可以先将数组排序（O(Nlog N)复杂度），然后针对每个数字，可以在其后的所有元素中利用类似二分查找的方式进行
     * 需要注意的是需要跳过重复数字以避免产生相同的解。但是这个问题可以利用Set来消除（又偷懒了）
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums == null || nums.length < 3) return new ArrayList<>(result);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            if (nums[k] < 0) break;
            while (j < k) {
                System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{3,0,-2,-1,1,2}));
    }
}
