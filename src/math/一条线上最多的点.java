package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/max-points-on-a-line/
 * @Author gcc
 * @Date 19-6-12 下午4:09
 **/
public class 一条线上最多的点 {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        // 以每个点作为线的起点
        for (int i = 0; i < points.length; i++) {
            map.clear();
            // 记录重叠的点的个数，重叠的点也算同一条线
            int overlap = 0, max = 0;
            // 以一些点作为线的终点
            // 不考虑线的双向，那么j从i+1开始取
            // 计算以points[i]作为起点的线中最多的点
            // 那么全局最多的点一定在 这些局部最多的线中
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                // 求出最大公约数，再除一下之后的（x,y）可以定义一条直线，因为线的起点已经固定
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;


    }

    private int generateGCD(int a, int b) {

        if (b == 0) return a;
        else return generateGCD(b, a % b);

    }


    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
