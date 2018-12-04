package tree;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @Author gcc
 * @Date 18-12-3 上午10:07
 **/

public class BST中最小公共祖先 {
    /**
     * 根节点的值一直都是中间值，大于左子树的所有节点值，小于右子树的所有节点值，
     * 那么我们可以做如下的判断，如果根节点的值大于p和q之间的较大值，说明p和q都在左子树中，那么此时我们就进入根节点的左子节点继续递归，
     * 如果根节点小于p和q之间的较小值，说明p和q都在右子树中，那么此时我们就进入根节点的右子节点继续递归，如果都不是，
     * 则说明当前根节点就是最小共同父节点，直接返回即可
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (true) {
            if (root.val > max) {
                root = root.left;
            } else if (root.val < min) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root == null) {
            return root;
        }
        if (root.val > max) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < min) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }

}
