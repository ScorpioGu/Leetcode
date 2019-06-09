package tree;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/convert-bst-to-greater-tree/
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * @Author gcc
 * @Date 19-6-9 下午10:35
 **/
public class BST转化为GreaterTree {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        convertBST(cur.right);
        if (pre != null) {
            cur.val += pre.val;
        }
        pre = cur;
        convertBST(cur.left);
    }


}
