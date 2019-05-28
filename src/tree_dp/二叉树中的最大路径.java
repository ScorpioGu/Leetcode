package tree_dp;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 * @Author gcc
 * @Date 18-11-11 下午1:38
 **/
public class 二叉树中的最大路径 {
    private class ReturnData {
        // 当前节点中的最大路径
        int max;
        // 当前节点中包含自己的最大路径
        int maxInclude;

        public ReturnData(int max, int maxInclude) {
            this.max = max;
            this.maxInclude = maxInclude;
        }
    }
    public int maxPathSum(TreeNode root) {
        return process(root).max;
    }

    /**
     * @param cur
     * @return 返回值为root这颗树下的最大路径
     */
    private ReturnData process(TreeNode cur) {
        if (cur == null) {
            // 因为节点中是存在负值的，所以不能初始化为0，
            return new ReturnData(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ReturnData ldata = process(cur.left);
        ReturnData rdata = process(cur.right);

        int max = Math.max(Math.max(ldata.max, rdata.max), Math.max(0, ldata.maxInclude) + Math.max(0, rdata.maxInclude) + cur.val);

        int maxInclude = Math.max(Math.max(0, ldata.maxInclude), Math.max(0, rdata.maxInclude)) + cur.val;
        return new ReturnData(max, maxInclude);
    }
}
