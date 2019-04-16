package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/basic-calculator/description/
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces
 *
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * @Author gcc
 * @Date 18-11-26 下午5:04
 **/
public class 实现计算器 {
    /**
     * 当遇到一个数字时,不着急将其计算,因为下一个字符仍然可能是数字
     * 当遇到+,-,)或者字符串末尾时再去计算它
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //res记录结果, number记录当前数字, sign记录操作数的前一个符号
        int res = 0, number = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = 10 * number + c - '0';
            } else if (c == '+') {
                res += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                res += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                //栈第二个元素记录之前的计算结果
                stack.push(res);
                //栈顶记录(之前是+还是-
                stack.push(sign);
                sign = 1;
                number = 0;
                res = 0;
            } else if (c == ')') {
                res += sign * number;
                res *= stack.pop();
                res += stack.pop();
                number = 0;
            }
        }
        return res += sign * number;
    }

    public static void main(String[] args) {
        System.out.println(new 实现计算器().calculate("(1+(4+5+2)-3)+(6+8) - 5"));
    }
}
