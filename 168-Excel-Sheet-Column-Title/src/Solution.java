public abstract class Solution {
    public abstract String convertToTitle(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(19));
        System.out.println(solution.convertToTitle(27));
        System.out.println(solution.convertToTitle(55));
        System.out.println(solution.convertToTitle(100));
        System.out.println(solution.convertToTitle(1000));
    }
}
