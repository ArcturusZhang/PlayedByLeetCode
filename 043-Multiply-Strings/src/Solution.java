import java.math.BigInteger;

public abstract class Solution {
    public abstract String multiply(String num1, String num2);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        BigInteger n1 = new BigInteger("17413");
        BigInteger n2 = new BigInteger("83197131");
        System.out.println(n1 + " * " + n2 + " = " + solution.multiply(n1.toString(), n2.toString()) + " == " + n1.multiply(n2));
    }
}
