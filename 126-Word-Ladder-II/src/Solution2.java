import java.util.*;

public class Solution2 extends Solution {
    /**
     * 记忆化搜索。将127中的BFS与DFS结合以降低DFS的复杂度，减少无用的分支。
     * 先利用与127题类似的方法查找最短路径，同时将查找得到的可行路径储存为一个map。
     * 然后利用回溯法和刚刚得到的map来给出所有的最短路径，不需要再重新遍历所有可能的路径。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (wordDict.size() == 0 || !wordDict.contains(endWord)) return result;
        wordDict.remove(beginWord);
        Set<String> reached = new HashSet<>(), remained = new HashSet<>(wordDict);
        reached.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int current = 1, next = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            current--;
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = String.valueOf(chars);
                    if (remained.contains(newWord)) {
                        if (reached.add(newWord)) {
                            next++;
                            queue.offer(newWord);
                        }
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord) && !flag) flag = true;
                    }
                }
            }
            if (current == 0) {
                if (flag) break;
                current = next;
                next = 0;
                remained.removeAll(reached);
                reached.clear();
            }
        }
        backTracking(endWord, beginWord, result, new LinkedList<>(), map);
        return result;
    }

    private void backTracking(String word, String beginWord, List<List<String>> result, List<String> current,
                              Map<String, List<String>> map) {
        if (word.equals(beginWord)) { // 回溯出口
            current.add(0, beginWord);
            result.add(new LinkedList<>(current));
            current.remove(0);
        } else { // 回溯主体
            current.add(0, word); // 加入当前单词
            if (map.containsKey(word)) { // 在map中查看当前单词的前序
                for (String preWord : map.get(word)) {
                    backTracking(preWord, beginWord, result, current, map); // 递归尝试之
                }
            }
            current.remove(0); // 回溯
        }
    }
}
