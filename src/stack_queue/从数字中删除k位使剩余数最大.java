package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/remove-k-digits/
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * <p>
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * @Author gcc
 * @Date 19-1-14 下午9:56
 **/

public class 从数字中删除k位使剩余数最大 {

    /**
     * 这是使用栈来做的
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        // stack中元素始终保持单调增,要删除的元素一定是符合中间高两边低的
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        //处理剩余的没有峰值的情况,比如1234,1111,这种就从最后开始删就行了
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        String remove0 = sb.toString().replaceAll("^(0+)", "");
        return remove0.equals("") ? "0" : remove0;
    }


    public static void main(String[] args) {
        System.out.println(new 从数字中删除k位使剩余数最大().removeKdigits("112", 1));
    }
}
