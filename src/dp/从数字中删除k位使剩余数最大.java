package dp;

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
     * 这是我自己做的一个方法,缺点在于每删除一个字符,findFirstPeak就要被调用一次
     * 比较耗时
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        //正则表达式把前面的0都删了
        num = num.replaceAll("^(0+)", "");
        if (k == 0) {
            return num.equals("") ? "0" : num;
        }
        int len = num.length();
        if (k >= len) {
            return "0";
        }
        //首先看一下第一个0出现在哪儿,如果出现在k之前,直接把0前面的都删了
        //如果第一个0出现在k以后,删除第一个顶峰
        int first0 = num.indexOf('0');
        if (first0 <= k && first0 != -1) {
            return removeKdigits(num.substring(first0), k - first0);
        } else {
            int removeIndex = findFirstPeak(num);
            return removeKdigits(new StringBuilder(num).deleteCharAt(removeIndex).toString(), k - 1);
        }
    }

    private int findFirstPeak(String nums) {
        for (int i = 0; i < nums.length() - 1; i++) {
            if (nums.charAt(i) > nums.charAt(i + 1)) {
                return i;
            }
        }
        return nums.length() - 1;
    }

    /**
     * 这是使用栈来做的
     * @param num
     * @param k
     * @return
     */
    public String removeKdigitsUsingStack(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i++));
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
