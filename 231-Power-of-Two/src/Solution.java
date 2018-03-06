public abstract class Solution {
    public abstract boolean isPowerOfTwo(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        int n = 1;
        for (int i = 0; i < 31; i++) {
            System.out.println(solution.isPowerOfTwo(n));
            System.out.println(solution.isPowerOfTwo(n + 1));
            n <<= 1;
        }
    }
}
