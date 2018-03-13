public abstract class Solution {
    public abstract int findComplement(int num);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
    }
}
