public abstract class Solution {
    public abstract int firstMissingPositive(int... nums);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.firstMissingPositive());
        System.out.println(solution.firstMissingPositive(3, 4, -1, 1));
        System.out.println(solution.firstMissingPositive(1, 2, 0));
        System.out.println(solution.firstMissingPositive(3, 2, 1));
        System.out.println(solution.firstMissingPositive(1));
        System.out.println(solution.firstMissingPositive(1, 1, 3));
    }
}
