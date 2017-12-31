public abstract class Solution {
    public abstract String intToRoman(int num);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(428));
        System.out.println(solution.intToRoman(3999));
    }
}
