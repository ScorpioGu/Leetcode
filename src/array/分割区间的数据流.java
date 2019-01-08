package array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Desc https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * @Author gcc
 * @Date 19-1-8 上午11:28
 **/
public class 分割区间的数据流 {
    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public 分割区间的数据流() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        //两边都相邻的情况
        if (l != null && h != null && map.get(l).end + 1 == val && val + 1 == map.get(h).start) {
            map.get(l).end = map.get(h).end;
            map.remove(h);
        } else if (l != null && val <= map.get(l).end + 1) {
            //与左边相邻或者在左边里面的情况
            map.get(l).end = Math.max(map.get(l).end, val);
        } else if (h != null && map.get(h).start - 1 == val) {
            map.put(val, new Interval(val, map.get(h).end));
            map.remove(h);
            // 不要写成下面这样,Interval虽然是对的,但是Map中的key没有修改
            // map.get(h).start = val;
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(map.values());
    }

    public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
    }
}
