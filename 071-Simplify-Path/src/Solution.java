public abstract class Solution {
    public abstract String simplifyPath(String path);

    public static void main(String[] args) {
        testCases(new Solution1());
    }
    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../"));
        System.out.println(solution.simplifyPath("/"));
    }
}
