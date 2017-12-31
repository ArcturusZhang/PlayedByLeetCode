public class Solution1 extends Solution {
    /**
     * 这个算法十分简单，没什么技术含量
     * @param strs
     * @return
     */
    @Override
    public String longestCommonPrefix(String... strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String target = strs[0];
        int length = target.length();
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            length = Math.min(length, current.length());
            while (length >= 0 && !current.startsWith(target.substring(0, length))) length--;
            if (length == 0) return "";
        }
        return target.substring(0, length);
    }
}
