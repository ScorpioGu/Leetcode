package slide_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
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
        int length = nums.length;
        int[] res = new int[length - k + 1];

        int l = 0, r = 0;
        Deque<Integer> deque = new LinkedList<>();
        //Deque存储数组索引,始终保持对头元素是当前窗口中最大元素的索引
        //窗口的右边界是r，左边界是r-k+1
        while (r < length) {

            // 右边界向外扩
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]) {
                deque.pollLast();
            }
            deque.offer(r);

            // 右边界扩完，有可能左边界越界，看是否需要删除，左边界为r - k的时候，左边界过期了
            if (!deque.isEmpty() && deque.peek() == r - k) {
                deque.poll();
            }

            // 在r = k - 1时，窗口长度才到k，可以保存最大值
            if (r >= k - 1) {
                res[l++] = nums[deque.peek()];
            }

            r++;
        }
        return res;
    }
}
