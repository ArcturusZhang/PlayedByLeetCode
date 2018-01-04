public class Solution1 extends Solution {
    /**
     * 类似于二分查找，
     * @param numbers
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) left++;
            else right--;
        }
        return new int[0];
    }
}
