package greedy;

import java.util.Arrays;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5240774.html
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * @Author gcc
 * @Date 19-6-9 上午9:55
 **/
public class 判断会议时间是否重叠 {
    public boolean canAttendMeetings(Interval[] intervals) {
        // 按开始时间排序
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
