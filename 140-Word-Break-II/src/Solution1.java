import java.util.*;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/word-break-ii/description/</url>
     * 解：
     * 直接利用回溯法求解。
     * 但是直接使用回溯法会造成Time Limit Exceeded，因为这种算法一般是指数级的时间复杂度。
     * @param s
     * @param wordDict
     * @return
     */
    @Override
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        wordBreakCore(s, 0, dict, result, new ArrayList<>());
        return result;
    }

    private void wordBreakCore(String s, int start, Set<String> dict, List<String> result, List<String> current) {
        if (start == s.length()) {
            result.add(currentToString(current));
        } else if (start < s.length()) {
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (dict.contains(word)) {
                    current.add(word);
                    wordBreakCore(s, end, dict, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private String currentToString(List<String> current) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = current.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) sb.append(" ");
        }
        return sb.toString();
    }
}
