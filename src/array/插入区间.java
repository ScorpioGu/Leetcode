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
public class 插入区间 {
    /**
     * 多画图，分类讨论。用for循环做不太好，用多段while更合适一点
     * @param intervals 给定的时间段不重叠，按开始事件升序
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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
        //第三段把与newInterval不重叠的存起来
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }


    public static void main(String[] args) {
        Interval a = new Interval(1, 5);
        Interval newI = new Interval(2, 3);
        List<Interval> res = new ArrayList<>();
        res.add(a);
        List<Interval> list = new 插入区间().insert(res, newI);
        for (Interval i : list) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
