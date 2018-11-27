package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/implement-stack-using-queues/description/
 * @Author gcc
 * @Date 18-11-26 下午6:26
 **/
public class 使用队列实现栈 {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public 使用队列实现栈() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
