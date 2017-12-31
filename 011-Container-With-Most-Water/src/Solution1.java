public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/container-with-most-water/description/</url>
     * 解：
     * 贪心算法。从数组的两侧开始，计算当前的面积，由于面积是由较短的板决定，因此将两侧较短的那一侧向内部推进。
     * 如果将较高的那一侧推进则面积必然减小（因为高度不可能增加，而宽度又减小了）。扫描至左右指针汇合，其中记录过的最大值即为所求。
     * 贪心算法都需要一个证明，但是我现在对贪心算法的证明还没有完全掌握，这里暂时略去。
     * @param height
     * @return
     */
    @Override
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) max = area;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
