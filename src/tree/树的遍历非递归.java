package tree;

import support.TreeNode;

import java.util.*;

public class 树的遍历非递归 {
    public static void 中序(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        //一般需要保存一下当前节点的前驱,不需要的可以不加
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                //这里加一些具体操作
                System.out.print(root.val + " ");

                //root移动到下一个位置
                pre = root;
                root = root.right;
            }
        }
    }

    public static void 前序(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //这里加一些具体的操作
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }



    public static void 后序(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (root != null) {
            //左子树入栈
            for (; root.left != null; root = root.left) {
                stack.push(root);
            }
            //当前结点无右子树或右子树已经输出
            while (root != null && (root.right == null || root.right == node)) {
                //这里加一些操作
                System.out.print(root.val + " ");

                //纪录上一个已输出结点
                node = root;
                if (stack.empty())
                    return;
                root = stack.pop();
            }
            //处理右子树
            stack.push(root);
            root = root.right;
        }
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






























