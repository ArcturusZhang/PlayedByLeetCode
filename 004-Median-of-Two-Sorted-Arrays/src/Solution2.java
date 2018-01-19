public class Solution2 extends Solution {
    /**
     * 将两个数组各自分为两部分，记数组A的长度为m，数组B的长度为n。将数组A分为i和m-i两部分，将数组B分为j和n-j两部分，
     * 并保持两个左部分元素个数与两个右部分元素个数相同（当总数为奇数时，左半部分元素个数比右半部分多1）。
     * 这要求i + j = m - i + n - j (+ 1)，也就是j = (m + n + 1) / 2 - i（这里是整数除法）
     * 问题变成了：在0到m中寻找一个i值，使得A[i-1] <= B[j]而且A[i] >= B[j-1]
     * 找到这样的i值之后，可以得到左半部分的最大值为leftMax = max(A[i-1], B[j-1])
     * 右半部分的最小值为rightMin = min(A[i], B[j])
     * 当元素总数为奇数时，最后的中位数就是leftMax（因为左半部分元素多1个）。
     * 当元素总数为偶数时，最后的中位数是(leftMax + rightMin) / 2.0
     * @param A
     * @param B
     * @return
     */
    @Override
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (n < m) return findMedianSortedArrays(B, A);
        int imin = 0, imax = m;
        while (imin < imax) {
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < imax && B[j - 1] > A[i]) {
                imin++;
            } else if (i > imin && A[i - 1] > B[j]) {
                imax--;
            } else {
                int leftMax = 0;
                if (i == 0) leftMax = B[j - 1];
                else if (j == 0) leftMax = A[i - 1];
                else leftMax = Math.max(A[i - 1], B[j - 1]);
                if ((m + n) % 2 == 1) return leftMax;
                int rightMin = 0;
                if (i == m) rightMin = B[j];
                else if (j == n) rightMin = A[i];
                else rightMin = Math.min(A[i], B[j]);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
