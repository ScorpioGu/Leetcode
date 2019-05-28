/**
 * Author:   gucheng
 * Date:     18-5-1 下午3:54
 * Description: https://leetcode.com/problems/balanced-binary-tree/description/
 */
package tree_dp;

import support.TreeNode;

/**
 *https://leetcode.com/problems/balanced-binary-tree/description/
 *平衡树的定义是， 一颗数为null,或者左右子树的深度差的绝对值不超过1
 */
public class 判断是否是平衡二叉树 {
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

        //当左右两数均不是平衡树时，必然就不是平衡树了，因为不是平衡数返回-1的原因
        //如果仍然使用绝对值之差<1这一条件会产生误判。所以这一块代码要放到下一块代码之前
        if ( leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        //当左右两数的深度绝对值之差大于1，则不是平衡树
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        //父节点的深度是左右两子数深度的较大者+1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
