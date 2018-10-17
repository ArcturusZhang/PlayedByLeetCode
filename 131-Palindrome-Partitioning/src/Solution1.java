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
            if (!isPalindrome(s, start, i - 1)) continue;
            // this substring is palindrome
            current.add(s.substring(start, i));
            partitionCore(s, i, end, result, current);
            current.remove(current.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
