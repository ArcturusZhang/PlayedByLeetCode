public class Solution1 extends Solution {
    /**
     * 从某个start开始遍历，如果从这个start开始到某个加油站油不够用了，说明这个start不能作为起点，从当前加油站的下一个地点重新开始计数即可。
     * 如果所有车站的gas-cost之和为负，那么从任何地点开始都不可能绕行一周。
     * @param gas
     * @param cost
     * @return
     */
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
