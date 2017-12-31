public class Solution1 extends Solution {
    /**
     * 题目描述：将罗马数字转化为阿拉伯数字。
     * 解：
     * 倒序遍历，当当前数字大于右边数字时，在结果上累加当前数字。当当前数字小于右边数字时，在结果上减去当前数字
     * @param s
     * @return
     */
    @Override
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = romanToArabic(s.charAt(s.length() - 1));
        if (s.length() == 1) return result;
        for (int i = s.length() - 2; i >= 0; i--) {
            int digit = romanToArabic(s.charAt(i));
            if (digit < romanToArabic(s.charAt(i + 1))) {
                result -= digit;
            } else {
                result += digit;
            }
        }
        return result;
    }

    private int romanToArabic(char c) {
        //final char[] ROME_LIST = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        //final int[] ARABIC_LIST = {1, 5, 10, 50, 100, 500, 1000};
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
