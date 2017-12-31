public abstract class Solution {
    public abstract String addBinary(String a, String b);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.addBinary("10", "1"));
        System.out.println(solution.addBinary("0", "11111"));
        System.out.println(solution.addBinary("1", "11111"));
    }
}
