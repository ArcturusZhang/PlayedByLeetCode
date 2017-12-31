public abstract class Solution {
    public abstract String getPermutation(int n, int k);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        for (int i = 1; i <= 6; i++) System.out.println(solution.getPermutation(3, i));
    }
}
