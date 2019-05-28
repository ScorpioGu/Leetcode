package stack_queue;

import java.util.LinkedList;

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
 *有空格，左右括号，+，-
 * @Author gcc
 * @Date 18-11-26 下午5:04
 **/
public class 计算器 {
    public int calculate(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * 递归调用，每当遇到一个左括号，则交给字一个子过程计算
     * 本次计算遇到一个右括号或者字符串末尾结束
     *
     * @param str 输入字符串
     * @param i   开始计算的索引
     * @return [0]为计算结果，[1]为结束位置，返回位置是为了父过程计算位置跳到结束位置+1
     */
    public int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        // 保存之前计算结果
        int pre = 0;
        while (i < str.length && str[i] != ')') {
            if (str[i] == ' ') {
                i++;
            } else if (Character.isDigit(str[i])) {
                // 遇到数字，累加到pre
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                // 遇到+ - * /
                // 将pre和运算符添加到双端队列
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                // 因为pre和运算符已经保存到队列中了，pre设为0
                pre = 0;
            } else {
                // 遇到了左括号，调用子过程
                int[] res = value(str, i + 1);
                pre = res[0];
                i = res[1] + 1;
            }
        }
        // 遇到）或者到字符串结束了，此时的pre还需要入栈，然后算出栈的结算结果
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    /**
     * 往队列尾添加元素,因为本题没有乘和除 直接入栈即可
     * @param que
     * @param num
     */
    public void addNum(LinkedList<String> que, int num) {
        que.addLast(String.valueOf(num));
    }

    /**
     * 计算队列的运算结果，从队列头开始计算
     * @param que
     * @return
     */
    public int getNum(LinkedList<String> que) {
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
