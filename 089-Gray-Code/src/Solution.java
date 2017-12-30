import java.util.List;

public abstract class Solution {
    public abstract List<Integer> grayCode(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.grayCode(4));
    }
}
