package tree_dp;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author gcc
 * @Date 18-12-3 上午10:29
 **/
public class 二叉树中的最小公共祖先 {
    /**
     * 如果当前节点等于p和q中的一个,那么就直接返回.
     * 如果不等于,则有三种情况.第一种情况,pq都在左子树,第二种情况,都在右子数,第三种情况,各一个
     * 对第一种情况与第二种情况肯定有其中一边的子树为null,返回不为null的那一方即可
     * 对于第三种情况,则当前节点就是最小公共祖先.
     * https://www.cnblogs.com/grandyang/p/4641968.html
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null?right:left;
    }
}
