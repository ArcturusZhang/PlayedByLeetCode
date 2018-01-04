import java.util.*;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/word-ladder/description/</url>
     * 解：
     * 广度优先搜索（BFS）。将每个单词想象为一棵树的一个节点，每个节点有若干个儿子，即为修改一个字母之后的结果。最先到达endWord时的树层高，
     * 必然是最小的修改次数。这与二叉树的层序遍历有相似之处，只不过这里是N叉树。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList), reached = new HashSet<>();
        if (!wordDict.contains(endWord)) return 0;
        wordDict.remove(beginWord);
        int length = 1;
        reached.add(beginWord);
        while (!reached.contains(endWord)) { // 如果达到endWord则结束循环
            Set<String> newWords = new HashSet<>(); // 用来储存下一层的所有叶子
            for (String word : reached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) { // 按顺序尝试所有可能的改变
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if (wordDict.contains(newWord)) { // 如果遇到一个可行的单词
                            newWords.add(newWord); // 将其加入下一层中
                            wordDict.remove(newWord); // 并且在字典中删除它，以防重复
                        }
                    }
                }
            }
            length++;
            if (newWords.size() == 0) return 0;
            reached = newWords; // 更新到下一层
        }
        return length;
    }
}
