public class Solution2 extends Solution {
    /**
     * 将跳跃过程分层，例如2 3 1 1 4 1 1
     * 第一层为起点 2，从第一层出发最多可以走2步，所以第二层有两个元素
     * 第二层为从第一层所有可以到达的点 3 1，从第二层出发可以走3步
     * 第三层为从第二层所有可以到达的点 1 4 1，从第三层出发可以走4步
     * 第四层为从第三层所有可以到达的点 1
     * 总共有4层，所以最少步数为3
     * @param nums
     * @return
     */
    @Override
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int last = 0, i = 0, level = 0; // i记录一层起点的索引，last记录这一层最远点的索引
        while (i <= last) {
            int furthest = last;
            for (; i <= last; i++) {
                furthest = Math.max(furthest, nums[i] + i); // 计算下一层的长度nums[i]
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            last = furthest;
        }
        return 0;
    }
}
