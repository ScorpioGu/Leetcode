package tree;

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
            stack.push(s);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        System.out.println(new 根据序列化结果判断二叉树是否是先序遍历().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
