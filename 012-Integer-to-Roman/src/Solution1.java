public class Solution1 extends Solution {
    private final String[] ROME_LIST = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] ARABIC_LIST = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * 九之类的数字和四之类的数字也要纳入考虑
     * @param num
     * @return
     */
    @Override
    public String intToRoman(int num) {
        if (num <= 0) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ROME_LIST.length; i++) {
            while (num >= ARABIC_LIST[i]) {
                num -= ARABIC_LIST[i];
                result.append(ROME_LIST[i]);
            }
        }
        return result.toString();
    }
}
