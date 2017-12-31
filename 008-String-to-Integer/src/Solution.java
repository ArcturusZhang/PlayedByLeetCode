public abstract class Solution {
    public abstract int myAtoi(String str);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.myAtoi("-0"));
        System.out.println(solution.myAtoi("0"));
        System.out.println(solution.myAtoi("+0"));
        System.out.println(solution.myAtoi("-1e3"));
        System.out.println(solution.myAtoi("241"));
        System.out.println(solution.myAtoi("-31094"));
        System.out.println(solution.myAtoi("-99999999999977"));
        System.out.println(solution.myAtoi("+99999999999999"));
        System.out.println(solution.myAtoi("99999999999999"));
        System.out.println(solution.myAtoi("99999s99999"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("-2147483647"));
        System.out.println(solution.myAtoi("-2147483648"));
        System.out.println(solution.myAtoi("-2147483649"));
    }
}
