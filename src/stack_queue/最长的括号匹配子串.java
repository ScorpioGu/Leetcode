package stack_queue;

import java.util.Stack;

public class 最长的括号匹配子串 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        //stack存的把那些能够匹配的括号剔除之后剩下的括号的坐标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (s.charAt(stack.peek()) == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }


        int max = 0;
        int first = s.length(), second;
        while (!stack.isEmpty()) {
            //用坐标作差来计算长度
            second = stack.pop();
            max = Math.max(first - second - 1, max);
            first = second;
        }
        max = Math.max(first, max);
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new 最长的括号匹配子串().longestValidParentheses("())"));
    }
}
