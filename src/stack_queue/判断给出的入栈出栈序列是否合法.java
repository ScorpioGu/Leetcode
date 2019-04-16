package stack_queue;

import java.util.Stack;

/**
 * @Desc https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author gcc
 * @Date 19-4-16 下午3:48
 **/
public class 判断给出的入栈出栈序列是否合法 {
    public boolean IsPopOrder(int[] push,int[] pop) {
        if (push == null || pop == null || push.length != pop.length) {
            return false;
        }
        // 先入栈,看栈顶元素是不是当前出栈序列中的元素
        // 如果是出栈,移动出栈序列的指针,再继续比较栈顶元素
        // 判断出错的条件是,push入完了,但是栈不为空
        Stack<Integer> stack = new Stack<>();
        int len = push.length;
        int i = 0, j = 0;
        while (i < len) {
            stack.push(push[i++]);
            while (!stack.isEmpty() && stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
