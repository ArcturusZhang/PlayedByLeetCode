import java.util.HashMap;

public class Solution1 extends Solution {
    /**
     * 记录历史信息的DFS，思路与131相同
     * @param s
     * @return
     */
    @Override
    public int minCut(String s) {
        return cutPalindrome(s, 0, 0, new HashMap<>());
    }

    private int cutPalindrome(String s, int start, int cut, HashMap<Integer, Integer> cache) {
        if (start >= s.length()) return cut - 1;
        if (cache.containsKey(start)) return cut + cache.get(start);
        int min = Integer.MAX_VALUE;
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                min = Math.min(min, cutPalindrome(s, end, cut + 1, cache));
            }
        }
        cache.put(start, min - cut);
        return min;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
