package backtrack_dfs_recursion;

import java.util.Stack;

/**
 * @Desc 一个栈，1 2 3 4 5,反转它使它变成 5 4 3 2 1
 * @Author gcc
 * @Date 19-5-23 下午4:13
 **/
public class 反转一个栈 {
    public void reverse(Stack<Integer> stack) {
        if (stack.size() < 2) {
            return;
        }
        // 比如1 2 3 4 5,获取到5并删除，stack还剩 1 2 3 4
        int last = getAndRemoveLast(stack);
        // 对1 2 3 4反转，变成4 3 2 1
        reverse(stack);
        // 将5压栈，变成5 4 3 2 1
        stack.push(last);

    }

    /**
     * 删除栈底元素并返回
     * @param stack
     * @return
     */
    private int getAndRemoveLast(Stack<Integer> stack) {
        // 进到这里面，肯定stack不会为空了
        int v = stack.pop();
        if (stack.isEmpty()) {
            return v;
        }
        int res = getAndRemoveLast(stack);
        stack.push(v);
        return res;
    }
}
