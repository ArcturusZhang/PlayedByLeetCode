public abstract class Solution {
    public abstract boolean checkPerfectNumber(int num);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber(64));
    }
}
