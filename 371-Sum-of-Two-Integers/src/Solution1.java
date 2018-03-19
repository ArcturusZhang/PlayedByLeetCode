public class Solution1 extends Solution {
    @Override
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (a != 0) {
            int carry = (a & b) << 1;
            b = a ^ b;
            a = carry;
        }
        return b;
    }
}
