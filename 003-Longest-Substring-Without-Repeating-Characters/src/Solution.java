import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 题目描述：Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     *      "pwke" is a subsequence and not a substring.
     * 解：
     * current和last为两个指针，指向“连续无重复字符子串”的首和尾。用一个集合来检验是否有重复，集合的大小即为子串长度。
     * 当current指向的字符集合中没有时，将其加入集合，然后查看下一字符。当current指向的字符已经在集合中存在时，将last所指向的字符移除，
     * 但不会查看下一字符，还要继续重复检查，直到当前指向的字符可以加入集合为止。
     * 用一个变量维护最大长度，在循环结束时返回即可。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int current = 0, last = 0;
        int max = 0;
        while (current < s.length()) {
            char c = s.charAt(current);
            if (!set.contains(c)) {
                set.add(c);
                if (set.size() > max) max = set.size();
                current++;
            } else {
                set.remove(s.charAt(last));
                last++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String string = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(string));
    }
}
