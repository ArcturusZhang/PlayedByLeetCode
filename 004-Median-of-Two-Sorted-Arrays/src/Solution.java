public abstract class Solution {
    public abstract double findMedianSortedArrays(int[] nums1, int[] nums2);

    public static void main(String[] args) {
//        testCases(new Solution1());
//        testCases(new Solution2());
        testCases(new Solution3());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.findMedianSortedArrays(new int[] {9}, new int[] {0, 2, 7, 8, 10, 19, 40}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2, 3, 4}, new int[] {5, 6}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2, 3, 4}, new int[] {-1}));
        System.out.println(solution.findMedianSortedArrays(new int[] {}, new int[] {-1}));
    }
}
