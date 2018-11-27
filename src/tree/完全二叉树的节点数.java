package tree;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 * @Author gcc
 * @Date 18-11-26 下午4:10
 **/
public class 完全二叉树的节点数 {
    int count;
    /**
     * 自然是不能通过全部遍历,会产生TLE,我们知道一颗完全二叉树是由很多完美二叉树组成的
     * 而完美二叉树的节点数只要直到了树的高度就可以直接得出.
     * 所以对任一节点,判断其左右子树的深度是否相等,相同则直接返回,否则递归调用其左右子节点
     *
     * 迭代做法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int leftHight = 0, rightHight = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            leftHight++;
            left = left.left;
        }
        while (right != null) {
            rightHight++;
            right = right.right;
        }
        if (leftHight == rightHight) {
            return (int)Math.pow(2, leftHight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 递归做法,这里递归就是在计算数深度的时候用到
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);
        if (leftDepth == rightDepth) {
            return (int)Math.pow(2, leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getLeftDepth(root.left);
    }

    private int getRightDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getRightDepth(root.right);
    }
}
