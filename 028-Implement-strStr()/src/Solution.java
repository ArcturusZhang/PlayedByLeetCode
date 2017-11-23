public class Solution {
    /**
     * 查找needle在haystack中第一次出现的索引，如果没有找到返回-1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        if (l2 == 0) return 0;
        int shift = l1 - l2;
        for (int start = 0; start <= l1 - l2; start++) {
            if (haystack.substring(start, start + l2).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("hello", "helloooo"));
    }
}
