public abstract class Solution {
    public abstract int numDecodings(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
//        System.out.println(solution.numDecodings("0"));
//        System.out.println(solution.numDecodings("10"));
//        System.out.println(solution.numDecodings("10545"));
//        System.out.println(solution.numDecodings("9035421"));
//        System.out.println(solution.numDecodings("820210"));
//        System.out.println(solution.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
        System.out.println(solution.numDecodings("*"));
        System.out.println(solution.numDecodings("**"));
    }
}
