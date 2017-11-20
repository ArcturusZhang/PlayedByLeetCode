public class Solution {
    /**
     * 题目描述：
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * Example 1:
     *      nums1 = [1, 3]
     *      nums2 = [2]
     *      The median is 2.0
     * Example 2:
     *      nums1 = [1, 2]
     *      nums2 = [3, 4]
     *      The median is (2 + 3)/2 = 2.5
     * 解：
     * 这是我使用的一种十分丑陋的解法，建立一个新数组，长度为两个所给数组之和，然后对两个数组进行归并排序（因为两个数组都是已排序的，所以这只需要
     * O(min(m,n))的复杂度，然后直接返回中位数。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pos1 = 0;
        int pos2 = 0;
        int count = 0;
        int total = nums1.length + nums2.length;
        int[] copy = new int[total];
        while (pos1 < nums1.length || pos2 < nums2.length) {
            if (pos1 >= nums1.length) {
                copy[count++] = nums2[pos2];
                pos2++;
                continue;
            }
            if (pos2 >= nums2.length) {
                copy[count++] = nums1[pos1];
                pos1++;
                continue;
            }
            if (nums1[pos1] < nums2[pos2]) {
                copy[count++] = nums1[pos1];
                pos1++;
            } else {
                copy[count++] = nums2[pos2];
                pos2++;
            }
        }
        int median;
        if (total % 2 == 0) {
            return (copy[total / 2] + copy[total / 2 - 1]) / 2.0d;
        } else {
            return (double)copy[total / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {0,2,7,9};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
