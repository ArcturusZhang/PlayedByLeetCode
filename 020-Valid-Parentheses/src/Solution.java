public abstract class Solution {
    public abstract boolean isValid(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isValid("(({{}}()[]))"));
        System.out.println(solution.isValid("(("));
        System.out.println(solution.isValid("(()]]"));
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("]"));
    }
}
