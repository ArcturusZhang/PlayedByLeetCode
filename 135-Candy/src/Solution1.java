public class Solution1 extends Solution {
    @Override
    public int candy(int[] ratings) {
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        left2right[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) left2right[i] = left2right[i - 1] + 1;
            else left2right[i] = 1;
        }
        right2left[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right2left[i] = right2left[i + 1] + 1;
            else right2left[i] = 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}
