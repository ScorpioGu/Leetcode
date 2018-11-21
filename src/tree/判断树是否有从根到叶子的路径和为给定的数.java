/**
 * Author:   gucheng
 * Date:     18-5-1 下午5:26
 * Description: https://leetcode.com/problems/path-sum/description/
 */
package tree;


import support.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/description/
 * 给定一棵二叉树和一个num，判断是否有一条从根节点到叶子节点的路径元素和等于num
 */
public class 判断树是否有从根到叶子的路径和为给定的数 {

    //递归做法，不谈了
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum != root.val) {
                return false;
            }
            return true;
        }
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
