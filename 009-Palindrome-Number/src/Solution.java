public class Solution {
    /**
     * 题目描述：
     * 编写一个函数，判定所给整数是否为回文数。
     * 解：
     * 直接将原数字翻转比较的方法不好用，第一点是复杂度高，第二点是容易溢出。
     * 所以采用将数字的后一半数字翻转，然后与余下的前半数字比较，如果相等（偶数位数）或者尾数除以10之后相等（奇数位数）就说明是回文数。
     * 容易遗忘的边界条件：10，20，30，。。。90，110，等数字不是回文数，但是上面的程序会将其判定为010之类从而认为他们是回文数，需要排除。
     * 即末位为0的回文数字只有0，其余的整十数字都不是。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0) return false;
        if (x < 0) return false;
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(123454321));
        System.out.println(new Solution().isPalindrome(12344321));
        System.out.println(new Solution().isPalindrome(1234567890));
        System.out.println(new Solution().isPalindrome(10));
    }
}
