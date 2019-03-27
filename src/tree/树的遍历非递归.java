package tree;

import support.TreeNode;

import java.util.*;

public class 树的遍历非递归 {
    public static void 中序(TreeNode cur) {
        if (cur == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        //一般需要保存一下当前节点的前驱,不需要的可以不加
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            //这里加一些具体操作
            System.out.print(cur.val + " ");

            //root移动到下一个位置
            pre = cur;
            cur = cur.right;
        }
    }

    public static void 前序(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //这里加一些具体的操作
                System.out.print(cur.val + " ");
                stack.push(cur);
                pre = cur;
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }


    public static List 后序(TreeNode cur) {
        List<Integer> list = new ArrayList<>();
        if (cur == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }

    public static void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode e = queue.poll();
            //这里加一些操作

            if (e.left != null) {
                queue.add(e.left);
            }

            if (e.right != null) {
                queue.add(e.right);
            }
        }
    }
}






























