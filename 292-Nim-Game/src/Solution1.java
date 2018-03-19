public class Solution1 extends Solution {
    /**
     * 倒推。
     * 当轮到对方的回合时，只有4个石子的情况下，对方是必败的，这时不论对方取走1个2个还是3个，余下的石子自己都可以一次取走。
     * 所以这个游戏的必胜策略就是将4个石子的情况留给对方。
     * 再推一步，为了让对方有4个石子这种状态，那么必然也要将8个石子的状态留给对方。
     * 所以只要n不能被4整除，我方先手的时候拿走1到3个石子使得石子数到对方手里是4的倍数，我方必胜。
     * @param n
     * @return
     */
    @Override
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
