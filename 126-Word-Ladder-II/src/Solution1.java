import java.util.*;

public class Solution1 extends Solution {
    /**
     * 解：（TLE）
     * 将这个过程想象为一个树，利用层序遍历（BFS）构造每一层的解答。但是得到的结果中会含有一些并非到达endWord的路径，最后遍历一次将其删除。
     * 在极端情形下超时了（而且会OOM，因为不做任何处理的DFS一般是指数级的复杂度）。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return new LinkedList<>();
        wordDict.remove(beginWord);
        LinkedList<List<String>> result = new LinkedList<>();
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        result.add(list);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        LinkedList<Set<String>> dicts = new LinkedList<>();
        dicts.add(wordDict);
        while (!reached.contains(endWord)) {
            Set<String> next = new HashSet<>();
            if (result.isEmpty()) return result;
            for (int i = result.size(); i > 0; i--) {
                List<String> current = result.poll();
                Set<String> dict = dicts.poll();
                String word = current.get(current.size() - 1);
                for (int idx = 0; idx < word.length(); idx++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[idx] = c;
                        String newWord = String.valueOf(chars);
                        if (dict.contains(newWord)) {
                            List<String> newList = new LinkedList<>(current);
                            newList.add(newWord);
                            result.add(newList);
                            Set<String> newDict = new HashSet<>(dict);
                            newDict.remove(newWord);
                            dicts.add(newDict);
                            next.add(newWord);
                        }
                    }
                }
            }
            reached = next;
        }
        for (int i = result.size(); i > 0; i--) {
            List<String> current = result.poll();
            if (current.get(current.size() - 1).equals(endWord)) result.add(current);
        }
        return result;
    }
}
