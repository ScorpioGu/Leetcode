package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/remove-duplicate-letters/
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 * @Author gcc
 * @Date 18-12-25 下午3:00
 **/
public class 删除重复的字符使得剩余结果是最小字典 {
    public String removeDuplicateLetters(String s) {
        //首先要保存每个字符出现多少次
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        //保存字符当前是否存在栈中,栈中元素不可以重复
        boolean[] isExist = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]--;
            if (isExist[index]) {
                continue;
            }

            //如果遇到栈顶元素比当前的大,并且栈顶元素后面还会再出现,那么就把栈顶元素给删了,到后面再添加,肯定是有更小的字典序
            //比如cbc,肯定是把前面一个c删了,保留后面的,如果是aba呢,必然是保留前面的ab
            //而如果遇到后面不会再出现的字符了,那就没办法选择了,直接入栈
            while (!stack.isEmpty() && (stack.peek() > c) && (count[stack.peek() - 'a'] != 0)) {
                char tmp = stack.pop();
                isExist[tmp - 'a'] = false;
            }

            stack.push(c);
            isExist[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
