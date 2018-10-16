public class Solution3 extends Solution {
    /**
     * 这是Solution2的改进版本，利用二分查找将时间复杂度优化到O(log(n+m))
     * lo和hi的初始取值根据0<=i<=n和0<=j<=m确定。
     * @param nums1
     * @param nums2
     * @return
     */
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n < m) return findMedianSortedArrays(nums2, nums1);
        int lo = (n - m + 1)/ 2, hi = (n + m + 1) / 2;
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = (m + n + 1) / 2 - i;
            int Al, Ar, Bl, Br;
            Al = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            Ar = i < n ? nums1[i] : Integer.MAX_VALUE;
            Bl = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            Br = j < m ? nums2[j] : Integer.MAX_VALUE;
            if (Al <= Br && Bl <= Ar) {
                // found right separator i
                int left = Math.max(Al, Bl);
                int right = Math.min(Ar, Br);
                if ((m + n) % 2 == 0) return (left + right) / 2.0;
                else return left;
            }
            if (Al > Br) hi = i;
            else if (Bl > Ar) lo = i + 1;
        }
        return 0;
    }
}
