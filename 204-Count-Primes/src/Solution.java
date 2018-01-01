public abstract class Solution {
    public abstract int countPrimes(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.countPrimes(3));
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(20));
        System.out.println(solution.countPrimes(100));
    }
}
