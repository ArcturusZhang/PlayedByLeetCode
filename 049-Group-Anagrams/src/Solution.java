import java.util.*;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/group-anagrams/description/</url>
     * 解：
     * 构建一个{@code String}到{@code List<String>}的Map，以某单词的所有字母从小到大排序作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
