public class Solution {
    /**
     * 这道题目没有什么值得一提的算法（竟然是个medium）
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : convertCore(s, numRows)) {
            result.append(sb);
        }
        return result.toString();
    }

    private StringBuilder[] convertCore(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int current = 1;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sbs[current - 1].append(c);
            current += direction;
            if (current > numRows) {
                direction *= -1;
                current = numRows - 1;
            }
            if (current < 1) {
                direction *= -1;
                current = 2;
            }
        }
        return sbs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 5));
    }
}
