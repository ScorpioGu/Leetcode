package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * @Author gcc
 * @Date 18-12-3 下午3:50
 **/
public class 滑动窗口中的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int l = nums.length;
        int[] res = new int[l - k + 1];
        int index = 0;
        //Deque存储数组索引,始终保持对头元素是当前窗口中最大元素的索引
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //窗口向右移动时,左边超出范围的移除队列
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            //窗口移动,在加入新元素之前把队位小于新元素的全都移出队列,它们是没有机会成为窗口中最大值的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
