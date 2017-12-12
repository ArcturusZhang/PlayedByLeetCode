import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /**
     * 这就是这个东西的最优算法。。。
     * 解法二：
     * 当然也可以递归，n=3的解是基于n=2得来的。
     * n=2的解为00, 01, 11, 10
     * n=3的解前一部分和n=2相同，为00, 01, 11, 10；
     * 后一部分首位为1，后面两位是前面的倒序，即110, 111, 101, 100
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.grayCode(4));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.grayCode(4));
    }
}
