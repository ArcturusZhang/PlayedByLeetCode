import arcturus.util.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/merge-intervals/description/</url>
     * 解：
     * 本题虽然标称为Medium，但实际上非常简单。先将所有区间按区间开始的大小排序。然后从头开始遍历，如果当前区间的start<=前一区间的end，
     * 那么将这个区间与前一区间合并即可。
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((Interval i1, Interval i2) -> {
            return i1.start - i2.start;
        });
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(solution.merge(intervals));
    }
}
