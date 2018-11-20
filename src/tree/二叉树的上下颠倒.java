package tree;

import support.TreeNode;

import java.util.Stack;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5172838.html
 * For example:
 *
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *
 * 这道题让我们把一棵二叉树上下颠倒一下，而且限制了右节点要么为空要么一定会有对应的左节点
 * 观察发现,最左边的节点变成了新的根节点,其右同胞变成了它的左孩子,其父节点变成了他的右孩子
 * @Author gcc
 * @Date 18-11-19 下午5:21
 **/
public class 二叉树的上下颠倒 {
    /**
     * 用栈实现递归
     * @param root
     * @return
     */
    public TreeNode reverseTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        //先用栈存一下吧
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        root = stack.pop();
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            cur.left = parent.right;
            cur.right = parent;
            //修改指针之后,把parent的指针清除
            parent.left = null;
            parent.right = null;
            cur = parent;
        }
        return root;
    }

    /**
     * 用递归实现 recursion
     * 这个方法,传入的root位置不会改变,返回值是新树的顶点位置
     * @param root
     * @return
     */
    public TreeNode reverseTree2(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode res = reverseTree2(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return res;
    }

    /**
     * 迭代的方式从上往下
     * @param root
     * @return
     */
    public TreeNode reverseTree3(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode cur = root, next = null, pre = null, tmp = null;
        while (cur != null) {
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
