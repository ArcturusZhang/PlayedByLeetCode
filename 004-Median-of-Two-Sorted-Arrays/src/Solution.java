public abstract class Solution {
    public abstract double findMedianSortedArrays(int[] nums1, int[] nums2);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2, 3}, new int[] {0, 2, 7, 9}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
    }
}
