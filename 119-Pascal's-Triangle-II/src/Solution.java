import java.util.List;

public abstract class Solution {
    public abstract List<Integer> getRow(int rowIndex);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ": " + solution.getRow(i));
        }
    }
}
