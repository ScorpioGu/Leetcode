package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Desc https://leetcode.com/problems/find-median-from-data-stream/
 * 设计一个类,能够快速地寻找中位数.
 *
 * 受题https://leetcode.com/problems/median-of-two-sorted-arrays/的启发,中位数就是将
 * 左边两边长度变为相等.使用两个优先队列来存储两边的元素,那求中位数就是对队头元素进行操作.
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * @Author gcc
 * @Date 18-12-15 上午10:28
 **/
public class MedianFinder {
    /**
     * 优先级队列在默认的情况下是最小的元素存在队列头部
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    /**
     * 如果当前数量为偶数,新增元素时默认将中位数放在right中,放哪个其实无所谓,只要存和取保持一致就好了
     * 如果当前数量为奇数,一定是right比left多了一个,那么新增元素之后,left和right应该要保持一样多
     * @param num
     */
    public void addNum(int num) {
        if (even) {
            left.offer(num);
            right.offer(left.poll());
        } else {
            right.offer(num);
            left.offer(right.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return left.peek() + (right.peek() - left.peek()) / 2.0;
        } else {
            return right.peek();
        }

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }
}
