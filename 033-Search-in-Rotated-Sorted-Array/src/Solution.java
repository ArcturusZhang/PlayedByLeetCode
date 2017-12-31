public abstract class Solution {
    public abstract int search(int[] nums, int target);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int[] nums = new int[] {4,5,6,7,0,1,2};
        for (int i = 0; i <= 8; i++) {
            System.out.println("Search for " + i + ": " + solution.search(nums, i));
        }
    }
}
