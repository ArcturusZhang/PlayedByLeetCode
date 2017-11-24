public class Solution {
    /**
     * 本题比较简单，从n=1的情况一直递推下去即可
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    private String countAndSay(String string) {
        StringBuilder result = new StringBuilder();
        int count = 1, digit, last = string.charAt(0) - '0';
        for (int i = 1; i < string.length(); i++) {
            digit = string.charAt(i) - '0';
            if (digit == last) count++;
            else {
                result.append(count).append(last);
                last = digit;
                count = 1;
            }
        }
        result.append(count).append(last);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int n = 0; n < 10; n++)
            System.out.println(n + ": " + solution.countAndSay(n));
    }
}
