package string;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Desc https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the
 *  expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 逆波兰表达式就是把操作数放前面，把操作符后置的一种写法，我们通过观察可以发现，第一个出现的运算符，
 * 其前面必有两个数字，当这个运算符和之前两个数字完成运算后从原数组中删去，把得到一个新的数字插入到
 * 原来的位置，继续做相同运算，直至整个数组变为一个数字
 * @Author gcc
 * @Date 18-11-18 上午11:32
 **/
public class 计算逆波兰表达式 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Set<String> operators = new HashSet<String>() {{
           add("*");
           add("/");
           add("+");
           add("-");
        }};

        for (String s : tokens) {
            if (operators.contains(s)) {
                int second = stack.pop();
                int first = stack.pop();
                if ("*".equals(s)) {
                    stack.push(first * second);
                } else if ("/".equals(s)) {
                    stack.push(first / second);
                } else if ("+".equals(s)) {
                    stack.push(first + second);
                } else if ("-".equals(s)) {
                    stack.push(first - second);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
