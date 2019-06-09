package greedy;

import java.util.Arrays;

/**
 * @Desc 按课的结束时间做贪心
 * @Author gcc
 * @Date 19-5-23 下午2:34
 **/
public class 选择会议使不重叠的会议最多 {
    public static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Interval[] intervals, int start) {
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start <= intervals[i].start) {
                result++;
                start = intervals[i].end;
            }
        }
        return result;
    }
}
