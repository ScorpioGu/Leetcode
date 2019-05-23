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
     * 自然是不能通过全部遍历,会产生TLE,我们知道一颗完全二叉树是由很多满二叉树组成的
     * 而完美二叉树的节点数只要直到了树的高度就可以直接得出.
     * 所以对任一节点,判断其左右子树的深度是否相等,相同则直接返回,否则递归调用其左右子节点
     *
     * 迭代做法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 2) {
            return h;
        }
        // 如果右子树的最大深度为h-1，那么左子树肯定是满的，节点个数是2^(h-1)-1,再加上右子树的节点数，再加上本身的1
        return height(root.right) == h-1 ? (1 << (h - 1)) + countNodes(root.right)
                //如果右子树的最大深度为h-2，那么右子树是满的，深度为h-2
                        : (1 << (h-2)) + countNodes(root.left);
    }

    /**
     * 求一颗树的最大深度，完全二叉树的最大深度可以通过向左走得到
     * @param root
     * @return
     */
    int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }
}
