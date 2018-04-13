import java.util.*;

public class Solution1 extends Solution {
    /**
     * BFS。
     * 例如对leetcode这个词和字典{leet, code}，可能的分割应该为{0, 4, 8}。将这个过程看作一个图，利用BFS遍历之，并且用一个HashSet来记录
     * 已经考察过的索引。
     * @param s
     * @param wordDict
     * @return
     */
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited.contains(start)) {
                visited.add(start);
                for (int i = start + 1; i <= s.length(); i++) {
                    String word = s.substring(start, i);
                    if (dict.contains(word)) {
                        if (i == s.length()) return true;
                        queue.offer(i);
                    }
                }
            }
        }
        return false;
    }
}
