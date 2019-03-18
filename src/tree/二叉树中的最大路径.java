package tree;

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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxPath;
    }

    /**
     * @param root
     * @return 返回值为root这颗树下的最大路径,必须包含root节点本身，左右只去大的那一边
     */
    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(recursion(root.left), 0);
        int r = Math.max(recursion(root.right), 0);
        //其实是动态规划,算出每个节点的最大路径(路径中必须包含该节点)
        //则全局的最大路径必然是每个节点最大路径中挑选出最大的一个
        //l和r做了与0比较的处理,所以l + r + root.val就是局部最优
        maxPath = Math.max(maxPath, l + r + root.val);
        //这里有可能是返回负值的,负值就不选取该分之的逻辑其实放在了40,41两行
        return Math.max(l, r) + root.val;
    }
}
