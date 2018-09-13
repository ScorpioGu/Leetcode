/**
 * Author:   gucheng
 * Date:     18-5-1 下午3:54
 * Description: https://leetcode.com/problems/balanced-binary-tree/description/
 */
package tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    //如果是Balanced，返回深度。否则返回一个代表是非Balanced的值-1
    //小技巧，当又希望返回一个数值类型又希望返回一个boolean类型并且一旦返回boolean类型就不再需要数值类型时，可以用一个无效的
    //数值来代替布尔类型，在方法调用处进行判断。
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        if ( leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
