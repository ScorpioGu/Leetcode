package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/insert-interval/description/
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * @Author gcc
 * @Date 18-10-23 下午8:53
 **/
public class 插入时间段 {
    /**
     * 多画图，分类讨论。用for循环做不太好，用多段while更合适一点
     * @param intervals 给定的时间段不重叠，按开始事件升序
     * @param newInterval
     * @return
     */
/*    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        boolean newIsAdd = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (!newIsAdd) {
                if (newInterval.start > cur.end) {
                    res.add(new Interval(cur.start, cur.end));
                } else if (newInterval.start < cur.start) {
                    //在外部,start不用变
                    if (newInterval.end < cur.start) {
                        //将newInterval添加了
                        res.add(new Interval(newInterval.start, newInterval.end));
                        res.add(new Interval(cur.start, cur.end));
                        newIsAdd = true;
                    } else {
                        newInterval.end = Math.max(newInterval.end, cur.end);
                    }
                } else {
                    //在cur内部
                    newInterval.start = cur.start;
                    if (newInterval.end <= cur.end) {
                        newInterval.end = cur.end;
                        res.add(new Interval(newInterval.start, newInterval.end));
                        newIsAdd = true;
                    }
                }
            } else {
                res.add(new Interval(cur.start, cur.end));
            }
        }
        if (!newIsAdd) {
            res.add(new Interval(newInterval.start, newInterval.end));
        }
        return res;

    }*/

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        //第一段把与newInterval不重叠的存起来
        int i=0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        //第二段把加入newInterval后所有重叠的存起来,
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }


    public static void main(String[] args) {
        Interval a = new Interval(1, 5);
//        Interval b = new Interval(2, 3);
        Interval newI = new Interval(2, 3);
//        Interval d = new Interval(15, 18);
        List<Interval> res = new ArrayList<>();
        res.add(a);
/*        res.add(b);
        res.add(c);
        res.add(d);*/
/*        Interval a1 = new Interval(1, 2);
        Interval a2 = new Interval(3, 5);
        Interval a3 = new Interval(6, 7);
        Interval a4 = new Interval(8, 10);
        Interval a5 = new Interval(12, 16);
        List<Interval> res = new ArrayList<>();
        res.add(a1);
        res.add(a2);
        res.add(a3);
        res.add(a4);
        res.add(a5);
        Interval newI = new Interval(4, 8);*/
        List<Interval> list = new 插入时间段().insert2(res, newI);
        for (Interval i : list) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
