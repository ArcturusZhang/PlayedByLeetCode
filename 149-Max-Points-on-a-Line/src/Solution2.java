import arcturus.util.Point;

import java.util.HashMap;
import java.util.Map;

public class Solution2 extends Solution {
    /**
     * 将斜率用既约分数（也就是一组整数）来表示，并用HashMap来查找相同斜率的点
     * @param points
     * @return
     */
    @Override
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            int line = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    same++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = String.valueOf(x) + "," + String.valueOf(y);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
                line = Math.max(line, map.get(slope));
            }
            max = Math.max(max, line + same + 1);
        }
        return max;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
