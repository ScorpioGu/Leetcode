/**
 * Author:   gucheng
 * Date:     18-5-1 下午4:29
 * Description: https://leetcode.com/problems/symmetric-tree/description/
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
/*    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    //left和right在整颗树里位置对称，而并非是父亲节点的左右孩子
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }*/

    //非递归做法，首先获取到左右两颗子树，分别去遍历两颗子树，注意遍历的方向一定要是对称的，层级遍历，一颗从左往游，另一颗从右往左。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode r1 = q1.poll();
            TreeNode r2 = q2.poll();
            if (r1.val != r2.val)
                return false;
            if (r1.left == null && r2.right != null || r1.left != null && r2.right == null)
                return false;
            if (r1.right == null && r2.left != null || r1.right != null && r2.left == null)
                return false;
            if (r1.left != null && r2.right != null) {
                q1.offer(r1.left);
                q2.offer(r2.right);
            }
            if (r1.right != null && r2.left != null) {
                q1.offer(r1.right);
                q2.offer(r2.left);
            }

        }
        return true;
    }
}
