public class Solution3 extends Solution {
    /**
     * 利用一个数组达到HashMap的效果。时间复杂度与Solution1相同。
     * @param s
     * @param t
     * @return
     */
    @Override
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] map = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != map[t.charAt(i) + 256]) return false;
            map[s.charAt(i)] = i + 1;
            map[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
