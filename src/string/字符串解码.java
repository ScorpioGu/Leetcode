package string;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/decode-string/
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @Author gcc
 * @Date 19-1-14 下午3:25
 **/
public class 字符串解码 {
    // 一个典型的模式是 字符+数字+[....]+字符
    public String decodeString(String s) {
        String res = "";
        //存放[前面的数字
        Stack<Integer> counts = new Stack<>();
        //存放[前面的字符串
        Stack<String> ss = new Stack<>();
        int index = 0;
        // 如果多个连续字符可以表示成一种意义(比如123)的推荐使用while而不是for,for的步长是固定的,而
        // while内部的可以根据需要自定义
        while (index < s.length()) {
            //数字不止一位,通过while循环找到连续的数字
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                counts.push(num);
            } else if (s.charAt(index) == '[') {
                ss.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(ss.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else {
                res += s.charAt(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 字符串解码().decodeString("2[abc]3[cd]ef"));
    }
}
