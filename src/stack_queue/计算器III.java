package stack_queue;

import java.util.LinkedList;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-28 下午4:59
 **/
public class 计算器III {
    public static int getValue(String str) {
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
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        // 保存之前计算结果
        int pre = 0;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
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
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    /**
     * 往队列尾添加元素
     * @param que
     * @param num
     */
    public static void addNum(LinkedList<String> que, int num) {
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
    public static int getNum(LinkedList<String> que) {
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

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));

    }
}
