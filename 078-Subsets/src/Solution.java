import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> subsets(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.subsets(1, 2, 3));
    }
}
