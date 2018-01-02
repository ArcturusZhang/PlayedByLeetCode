import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    public abstract int minimumTotal(List<List<Integer>> triangle);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(3, 4)),
                new ArrayList<>(Arrays.asList(6, 5, 7)),
                new ArrayList<>(Arrays.asList(4, 1, 8, 3))
        ));
        System.out.println(solution.minimumTotal(triangle));
    }
}
