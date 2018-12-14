package design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/peeking-iterator/
 * 实现带有peek功能的迭代器
 * @Author gcc
 * @Date 18-12-14 上午10:59
 **/
public class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            queue.offer(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
