package tree;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/flatten-binary-tree-to-linked-linklist/description/
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 博客地址:https://www.cnblogs.com/grandyang/p/4293853.html
 * @Author gcc
 * @Date 18-11-5 上午11:17
 **/
public class 将二叉树转成链表 {
    /**
     * 要求空间复杂度为in-place
     * @param root
     */
    TreeNode temp;

    /**
     * 递归解法,后序遍历，先把左右子树整好了之后，访问根节点，将指针关系指好
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

    /**
     * 非递归解法
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (root != null) {
            if (cur.left != null) {
                TreeNode p = cur.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}
