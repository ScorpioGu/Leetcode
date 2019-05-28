package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc https://leetcode.com/problems/basic-calculator-ii/description/
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * @Author gcc
 * @Date 18-11-26 下午6:57
 **/
public class 计算器II {
    /**
     * 用栈存储每个运算单元的值,对于* /需要两个操作数的,从栈顶取出前一个的计算结果
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<String> queue = new LinkedList<>();
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                // 数字的情况
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == ' ') {
                // 空格的情况
                continue;
            } else {
                // 运算符的情况
                addNum(queue, num);
                queue.offerLast(String.valueOf(s.charAt(i)));
                num = 0;
            }
        }
        addNum(queue, num);
        return getNum(queue);
    }

    /**
     * 往队列尾添加元素
     * @param que
     * @param num
     */
    public void addNum(Deque<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.peekLast();
            // 如果栈顶是 乘除 ， 需要计算，计算完再入队列
            if (top.equals("*") || top.equals("/")) {
                String sign = que.pollLast();
                int preNum = Integer.parseInt(que.pollLast());
                int res = sign.equals("*") ? (preNum * num) : (preNum / num);
                que.offerLast(String.valueOf(res));
                return;
            }
        }
        // 如果栈为空，或者栈顶为+ - 直接入栈
        que.addLast(String.valueOf(num));
    }

    /**
     * 计算队列的运算结果，从队列头开始计算
     * @param que
     * @return
     */
    public int getNum(Deque<String> que) {
        int res = 0;
        boolean add = true;
        while (!que.isEmpty()) {
            String cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                int num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
