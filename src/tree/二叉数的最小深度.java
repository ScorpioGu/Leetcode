/**
 * Author:   gucheng
 * Date:     18-5-1 下午3:06
 * Description: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
package tree;

import support.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class 二叉数的最小深度 {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //如果左右子树其中一颗为空，最小深度就不能是其中两子树深度较小者+1。
        if (root.left ==null) {
            return helper(root.right) + 1;

        }

        if (root.right == null) {
            return helper(root.left) + 1;
        }
        return Math.min(helper(root.left),helper(root.right)) + 1;
    }
}
