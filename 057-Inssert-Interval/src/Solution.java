import arcturus.util.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/insert-interval/description/</url>
     * 解：
     * 比较简单的一道题目。从头到尾遍历所有已有的区间即可。列表中的区间与新区间之间有三种情形：
     * 1. {@code interval.end < newInterval.start}：区间在新区间之前，两者不相交
     * 2. {@code interval.start > newInterval.end}：区间在新区间之后，两者不相交
     * 3. 其他情形：区间和新区间相交，记录start的最小值和end的最大值，在遍历完所有相交区间之后，将其作为新区间加入新列表即可。
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        int start = newInterval.start, end = newInterval.end;
        boolean flag = true;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) result.add(interval);
            else if (interval.start > newInterval.end) {
                if (flag) {
                    result.add(new Interval(start, end));
                    flag = false;
                }
                result.add(interval);
            } else {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
        }
        if (flag) result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        System.out.println(solution.insert(intervals, new Interval(4,9)));
    }
}
