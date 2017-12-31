import java.util.*;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/</url>
     * 解：
     * 创建一个HashMap保存字典，然后遍历字符串，检查下个单词是否还在字典中且没有使用过即可。
     * 这里需要注意一点：将HashMap清空，然后再逐渐添加新的词条可能会消耗较多时间，而基于已有HashMap创建一个新的Map，再逐条删除则比较快。
     * @param s
     * @param words
     * @return
     */
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
        int wordLength = words[0].length();
        int n = words.length;
        if (s.length() < n * wordLength) return result;
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.containsKey(word) ? dict.get(word) + 1 : 1);
        }
        for (int i = 0; i <= s.length() - n * wordLength; i++) {
            Map<String, Integer> copy = new HashMap<>(dict);
            for (int j = 0; j < n; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (copy.containsKey(word)) { // 剩余的词中有这个词
                    int count = copy.get(word);
                    if (count == 1) copy.remove(word);
                    else copy.put(word, count - 1);
                    if (copy.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else break;
            }
        }
        return result;
    }
}
