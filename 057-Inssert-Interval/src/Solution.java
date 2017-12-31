import arcturus.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    public abstract List<Interval> insert(List<Interval> intervals, Interval newInterval);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(1,2), new Interval(3,5), new Interval(6,7), new Interval(8,10), new Interval(12,16)
        ));
        System.out.println(solution.insert(intervals, new Interval(4,9)));
    }
}
