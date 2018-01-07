public class Solution1 extends Solution {
    @Override
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        convertCore(n - 1, sb);
        return sb.reverse().toString();
    }

    private void convertCore(int n, StringBuilder sb) {
        if (n < 0) return;
        if (n == 0) {
            sb.append('A');
            return;
        }
        sb.append((char) ('A' + n % 26));
        convertCore(n / 26 - 1, sb);
    }
}
