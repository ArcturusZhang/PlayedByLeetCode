public abstract class Solution {
    public abstract int reverseBits(int n);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.reverseBits(0b00000010100101000001111010011100));
    }
}
