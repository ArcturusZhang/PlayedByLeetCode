import java.util.Arrays;

public class Solution1 extends Solution {
    /**
     * 解：
     * 利用比较器和排序，非常容易。
     * @param nums
     * @return
     */
    @Override
    public String largestNumber(int... nums) {
        if (nums == null || nums.length == 0) return "";
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, (String str1, String str2) -> (str2 + str1).compareTo(str1 + str2));
        StringBuilder sb = new StringBuilder();
        for (String string : numsString) {
            sb.append(string);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
