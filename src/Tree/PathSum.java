/**
 * Author:   gucheng
 * Date:     18-5-1 下午5:26
 * Description: https://leetcode.com/problems/path-sum/description/
 */
package Tree;

public class PathSum {
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
