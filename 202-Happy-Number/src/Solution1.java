import java.util.HashSet;
import java.util.Set;

public class Solution1 extends Solution {
    /**
     * 解：
     * 根据题目的解释，按照给定的步骤循环计算新的数字，并将新的数字储存在一个HashSet中。如果新的数字等于1，那么此数是Happy的。
     * 如果新的数字在HashSet中已存在，说明计算形成了循环，此数不是Happy的。
     * @param n
     * @return
     */
    @Override
    public boolean isHappy(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit * digit;
            }
            if (!set.add(sum)) return false;
            n = sum;
        }
        return true;
    }
}
