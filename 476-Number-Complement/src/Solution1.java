public class Solution1 extends Solution {
    /**
     * 5在二进制下是101，题目要求将其翻转变成010也就是2。直接做位反操作会将101前面的29位0都变成1，所以需要在位反之后再与111这个数字做位与。
     * 先获得5的二进制位数，然后将-1左移(位数)位，这样将得到1.........1000（对5来说），对这个数字做位反，就得到了这个111.
     * @param num
     * @return
     */
    @Override
    public int findComplement(int num) {
        int count = 0;
        int n = num;
        while (n != 0) {
            count++;
            n >>>= 1;
        }
        System.out.println("count = " + count);
        return (~num) & (~((-1) << count));
    }
}
