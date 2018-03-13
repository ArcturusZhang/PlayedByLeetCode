import arcturus.util.Point;

import java.util.Arrays;

public abstract class Solution {
    public abstract int maxPoints(Point[] points);

    public static void main(String[] args) {
        testCases(new Solution1());
        testCases(new Solution2());
    }

    private static void testCases(Solution solution) {
        System.out.println(solution.getClass().getName());
//        Point[] points = new Point[] {
//                new Point(0, 0), new Point(3,3), new Point(1, 1), new Point(2, 1)
//        };
//        Point[] points = new Point[] {
//                new Point(0, 0), new Point(1,1), new Point(0, 0), new Point(3, 3)
//        };
        Point[] points = new Point[] {
                new Point(0, 0), new Point(1,1), new Point(1, -1)
        };
        System.out.println(solution.maxPoints(points));
        System.out.println(Arrays.toString(points));
    }
}
