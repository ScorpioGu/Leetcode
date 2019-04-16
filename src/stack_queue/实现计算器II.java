package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/basic-calculator-ii/description/
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * @Author gcc
 * @Date 18-11-26 下午6:57
 **/
public class 实现计算器II {
    /**
     * 用栈存储每个运算单元的值,对于* /需要两个操作数的,从栈顶取出前一个的计算结果
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        //记录当前操作数的前一个操作符
        char sign = '+';
        int len = s.length();
        int num = 0, res = 0;
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (Integer integer : stack) {
            res += integer;
        }
        return res;
    }
}
