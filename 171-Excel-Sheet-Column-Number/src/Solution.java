public abstract class Solution {
    public abstract int titleToNumber(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("G"));
        System.out.println(solution.titleToNumber("GG"));
        System.out.println(solution.titleToNumber("ALL"));
    }
}
