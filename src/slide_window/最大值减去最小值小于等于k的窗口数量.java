package slide_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-27 下午3:04
 **/
public class 最大值减去最小值小于等于k的窗口数量 {
    int getNum(int[] nums, int k) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        int l = 0, r = 0, res = 0;
        while (l < nums.length) {
            // 求最大窗口，从满足条件->不满足条件

            // 对每一个固定的左边界l，扩它的右边界r，一直扩到不满足条件.那么最后一个满足条件的右边界就是r-1
            // 那么对于以l为左边界的，r-1为右边界的窗口中，共有r-1-l+1=r-l个以l为左边界的子数组可以满足条件
            // 算出以每个l作为左边界的子数组的数量累加就是所求结果
            while (r < nums.length) {

                // 保持单调减
                while (!maxQueue.isEmpty() && maxQueue.peekLast() <= nums[r]) {
                    maxQueue.pollLast();
                }
                maxQueue.offerLast(r);

                // 保持单调增
                while (!minQueue.isEmpty() && minQueue.peekLast() >= nums[r]) {
                    minQueue.pollLast();
                }
                minQueue.offerLast(r);

                // 不满足条件，跳出循环
                if (maxQueue.peek() - minQueue.peek() > k) {
                    break;
                }
                // 满足条件继续扩
                r++;
            }

            // 此时准备左移了，把即将过期的左边界移除
            if (maxQueue.peek() == l) {
                maxQueue.pollFirst();
            }
            if (minQueue.peek() == l) {
                minQueue.pollFirst();
            }

            // 其实res 应当是等于r' - l + 1,r'是最大的满足条件的右边界，但是我们是把r移到了r'+1
            // 所以res += r' - l + 1 = r - l
            res += r - l;

            l++;

        }
        return res;
    }

}
