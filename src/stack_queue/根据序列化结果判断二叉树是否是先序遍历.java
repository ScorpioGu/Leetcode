package stack_queue;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * @Author gcc
 * @Date 19-1-3 下午10:23
 **/
public class 根据序列化结果判断二叉树是否是先序遍历 {
    /**
     * 为什么想到用栈,因为先序遍历不管是递归还是非递归的方式本质上就是用栈来做的
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String s : ss) {
            while ("#".equals(s) && !stack.isEmpty() && "#".equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            // 无论s是否是叶子节点,都将其入栈

            stack.push(s);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        // 对于非叶子节点,它提供了2个出度,消耗1个入度.对于叶子节点,它提供了0个出度,1个入度
        // diff = 出度-入度,若diff<0,则false
        // 假设我们在构建一棵树,每遇到一个新的节点,则消耗一个出度,diff减1,然后判断是否为叶子节点,是的话diff不变,不是的话diff+2
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        // 最终构建完应该diff=0
        return diff == 0;
    }
    public static void main(String[] args) {
        System.out.println(new 根据序列化结果判断二叉树是否是先序遍历().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
