public abstract class Solution {
    public abstract boolean isPalindrome(int x);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.isPalindrome(123454321));
        System.out.println(solution.isPalindrome(12344321));
        System.out.println(solution.isPalindrome(1234567890));
        System.out.println(solution.isPalindrome(10));
    }
}
