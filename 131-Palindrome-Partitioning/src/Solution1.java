import java.util.ArrayList;
import java.util.List;

public class Solution1 extends Solution {
    @Override
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionCore(s, 0, s.length(), result, new ArrayList<>());
        return result;
    }

    private void partitionCore(String s, int start, int end, List<List<String>> result, List<String> current) {
        if (start == end) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start + 1; i <= end; i++) {
            // determine if s[start, i] is palindrome
            int lo = start, hi = i - 1;
            boolean isPalindrome = true;
            while (lo < hi) {
                if (s.charAt(lo++) != s.charAt(hi--)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome) continue;
            // this substring is palindrome
            current.add(s.substring(start, i));
            partitionCore(s, i, end, result, current);
            current.remove(current.size() - 1);
        }
    }
}
