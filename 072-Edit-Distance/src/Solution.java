public abstract class Solution {
    public abstract int minDistance(String word1, String word2);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.minDistance("main", "male"));
        System.out.println(solution.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }
}
