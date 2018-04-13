import java.util.*;

public class Solution2 extends Solution {
    /**
     * 缓存的DFS，避免重复分支搜索
     */
    private Map<String, List<String>> cache = new HashMap<>();
    @Override
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakCore(s, new HashSet<>(wordDict));
    }

    private List<String> wordBreakCore(String s, Set<String> wordDict) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreakCore(s.substring(word.length()), wordDict);
                for (String sub : subList)
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        cache.put(s, result);
        return result;
    }
}
