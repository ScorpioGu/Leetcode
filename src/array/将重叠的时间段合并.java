package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/merge-intervals/description/
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * @Author gcc
 * @Date 18-10-23 下午7:53
 **/
public class 将重叠的时间段合并 {
    public List<Interval> merge(List<Interval> intervals) {
        //先排个序吧
        //Arrays.sort(intervals, new co(Interval a, Interval b) -> (a.start - b.start));
        //用前一个数-后一个数，是升序。反之是降序，
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort((a, b) -> (a.start - b.start));
        List<Interval> res = new ArrayList<>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                //这里不着急添加到res中，因为可能下一次循环还要修改的
                pre.end = Math.max(pre.end, cur.end);
            } else {
                //到这个循环中，说明pre的end不会再修改了
                //这里不可以直接add（pre）,必须new出一个新的对象，pre这个指针会不断修改的
                res.add(new Interval(pre.start, pre.end));
                pre = cur;
            }
        }
        //最后一个Interval不要忘记添加了
        res.add(pre);
        return res;
    }





    public static void main(String[] args) {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        Interval d = new Interval(15, 18);
        List<Interval> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        List<Interval> list = new 将重叠的时间段合并().merge(res);
        for (Interval i : list) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


