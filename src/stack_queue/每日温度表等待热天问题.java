package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/daily-temperatures/
 * @Author gcc
 * @Date 19-6-10 下午10:16
 **/
public class 每日温度表等待热天问题 {
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
