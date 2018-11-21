/**
 * Author:   gucheng
 * Date:     18-5-1 下午8:37
 * Description: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
package tree;

import support.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class 求树的所有路径和每一层乘10 {


    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    //遍历到这个节点的时候，上面的和是sum
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 10 * sum + root.val;
        }
        return helper(root.left, 10 * sum + root.val) + helper(root.right, 10 * sum + root.val);

    }
}
