public class Solution {
    /**
     * 智障题目。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strings = s.split(" ");
        if (strings.length == 0) return 0;
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello world!"));
    }
}
