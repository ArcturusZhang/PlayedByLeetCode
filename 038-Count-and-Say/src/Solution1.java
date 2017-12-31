public class Solution1 extends Solution {
    /**
     * 本题比较简单，从n=1的情况一直递推下去即可
     * @param n
     * @return
     */
    @Override
    public String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = countAndSayCore(result);
        }
        return result;
    }

    private String countAndSayCore(String string) {
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
}
