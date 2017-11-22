import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length < 4) return new ArrayList<>(set);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1, h = nums.length - 1;
                while (k < h) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[h];
                    if (sum == target) {
                        set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[h])));
                        k++;
                        h--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }
}
