package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5244720.html
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * @Author gcc
 * @Date 19-6-9 上午10:28
 **/
public class 安排所有会议所需要的最少会议室数 {
    int minMeetingRooms(Interval[] intervals) {
        // 对interval按开始时间安排好，一个个地进行安排
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        // pq存在所使用的会议室的结束时间，那么堆顶元素就是当前所使用的会议室的最早结束时间。每过来一个会议，让其开始时间与堆顶元素比较
        // 如果大于等于，重用这个会议室，否则只能分配一个新的会议室
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start) {
                // 堆顶的那个会议室可以重用,于是修改会议结束时间
                pq.poll();
                pq.offer(interval.end);
            } else {
                // 不能重用，只能重新分配
                pq.offer(interval.end);
            }
        }
        return pq.size();
    }

    public class Interval {
        int start;
        int end;
    }
}
