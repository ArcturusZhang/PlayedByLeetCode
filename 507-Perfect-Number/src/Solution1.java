public class Solution1 extends Solution {
    @Override
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int factor = 2; factor * factor <= num; factor++) {
            if (num % factor == 0) {
                sum += factor + num / factor;
            }
        }
        return num == sum;
    }
}
