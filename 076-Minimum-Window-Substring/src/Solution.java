public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/minimum-window-substring/description/</url>
     * 解：
     * 1. 统计t中各字母数，同时维护一个计数器count，记录t中还未在s子串中出现的字母数
     * 2. start = 0。
     * 3. 从start开始寻找一个可以恰好覆盖t的子串。此时count = 0
     * 4. 移动start直到遇到下一个在t中出现过的字母。
     * 5. 回到第三步
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        if (s.length() < t.length()) return "";
        int[] map = new int[26];
        for (char c : t.toCharArray()) {
            map[c - 'A']++;
        }
        char[] str = s.toCharArray();
        int start = 0, end = 0, count = t.length();
        int left = 0, min = Integer.MAX_VALUE;
        while (end < s.length()) {
            map[str[end] - 'A']--;
            if (map[str[end] - 'A'] >= 0) {
                count--;
            }
            if (count == 0) {
                int idx = str[start] - 'A';
                while (map[idx] < 0) {
                    map[idx]++;
                    start++;
                    idx = str[start] - 'A';
                }
                int len = end - start + 1;
                if (len < min) {
                    left = start;
                    min = len;
                }
                map[idx]++;
                start++;
                count++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(left, left + min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
