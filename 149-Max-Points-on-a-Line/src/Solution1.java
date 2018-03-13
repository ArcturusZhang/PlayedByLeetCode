import arcturus.util.Point;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 extends Solution {
    /**
     * 利用斜率和排序的解答，可能是由于Double的精度问题，导致有些点没有找到
     * @param points
     * @return
     */
    @Override
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        Arrays.sort(points, (p1, p2) -> {
            if (p1.y != p2.y) return p1.y - p2.y;
            else return p1.x - p2.x;
        });
        for (int i = 0; i < points.length - 1; i++) {
            Comparator<Point> comparator = new SlopeComparator(points[i]);
            Arrays.sort(points, i + 1, points.length, comparator);
            int count = 1;
            for (int j = i + 2; j < points.length; j++) {
                if (comparator.compare(points[j], points[j - 1]) == 0) {
                    count++;
                } else {
                    if (count > max) max = count;
                    count = 1;
                }
            }
            if (count > max) max = count;
        }
        return max + 1;
    }

    private class SlopeComparator implements Comparator<Point> {
        private Point point;
        SlopeComparator(Point point) {
            this.point = point;
        }
        @Override
        public int compare(Point o1, Point o2) {
            if (equals(point, o1) || equals(point, o2)) return 0;
            return Double.compare(slope(point, o1), slope(point, o2));
        }

        private boolean equals(Point p1, Point p2) {
            return (p1.x == p2.x && p1.y == p2.y);
        }
    }

    private double slope(Point p1, Point p2) {
        return 1.0 * (p1.y - p2.y) / (p1.x - p2.x);
    }
}
