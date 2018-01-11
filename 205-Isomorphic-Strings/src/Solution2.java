import java.util.HashMap;
import java.util.Map;

public class Solution2 extends Solution {
    /**
     * 利用一个HashMap。但containsValue方法不具有O(1)的复杂度，所以这种方法复杂度会高一些。
     * @param s
     * @param t
     * @return
     */
    @Override
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
