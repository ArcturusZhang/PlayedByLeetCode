import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * n=3的解是基于n=2得来的。
     * n=2的解为00, 01, 11, 10
     * n=3的解前一部分和n=2相同，为00, 01, 11, 10；
     * 后一部分首位为1，后面两位是前面的倒序，即110, 111, 101, 100
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) | 1 << i);
            }
        }
        return result;
    }
}
