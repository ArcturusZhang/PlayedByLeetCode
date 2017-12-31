import java.util.List;

public abstract class Solution {
    public abstract List<List<Integer>> subsetsWithDup(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.subsetsWithDup(new int[] {1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[] {3, 3, 3, 4}));
    }
}
