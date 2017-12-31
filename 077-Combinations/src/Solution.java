import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> combine(int n, int k);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.combine(4, 2));
    }
}
