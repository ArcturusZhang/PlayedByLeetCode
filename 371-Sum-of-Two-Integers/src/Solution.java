import java.util.Random;

public abstract class Solution {
    public abstract int getSum(int a, int b);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        Random random = new Random();
        for (int n = 0; n < 10; n++) {
            int a = random.nextInt(Integer.MAX_VALUE / 2), b = random.nextInt(Integer.MAX_VALUE / 2);
            int sum = solution.getSum(a, b);
            System.out.println(a + " + " + b + " = " + sum + "  " + (a + b == sum ? "Correct" : "Not correct"));
        }
    }
}
