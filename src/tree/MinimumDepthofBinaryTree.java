/**
 * Author:   gucheng
 * Date:     18-5-1 下午3:06
 * Description: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
package tree;

public class MinimumDepthofBinaryTree {
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
/*    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode e = queue.poll();
            cur--;
            if (e.right == null && e.left == null) {
                return ++level;
            }
            if (e.left != null) {
                queue.add(root.left);
                next++;
            }
            if (e.right != null) {
                queue.add(root.right);
                next++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
        }
        return 0;
    }*/
}
