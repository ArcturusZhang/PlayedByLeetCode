import java.util.List;

public abstract class Solution {
    public abstract List<String> restoreIpAddresses(String s);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("010010"));
    }
}
