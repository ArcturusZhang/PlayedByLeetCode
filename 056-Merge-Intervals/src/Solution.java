import arcturus.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {
    public abstract List<Interval> merge(List<Interval> intervals);

    public static void main(String[] args) {
        testCases(new Solution1());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)));
        System.out.println(solution.merge(intervals));
    }
}
