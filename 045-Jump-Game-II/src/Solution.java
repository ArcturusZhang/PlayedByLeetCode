public abstract class Solution {
    public abstract int jump(int[] nums);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getSimpleName());
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        int[] array = new int[1001];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - 1 - i;
        }
        System.out.println(solution.jump(array));
    }
}
