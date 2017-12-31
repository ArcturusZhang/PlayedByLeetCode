public class Solution1 extends Solution {
    /**
     * 意义不明的题目。
     * @param s
     * @return
     */
    @Override
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strings = s.split(" ");
        if (strings.length == 0) return 0;
        return strings[strings.length - 1].length();
    }
}
