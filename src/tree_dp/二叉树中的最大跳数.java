package tree_dp;

import support.TreeNode;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-28 下午12:11
 **/
public class 二叉树中的最大跳数 {
    private class ReturnType {
        int maxDepth;
        int maxDistance;

        ReturnType(int maxDepth, int maxDistance) {
            this.maxDepth = maxDepth;
            this.maxDistance = maxDistance;
        }
    }

    public int maxPathSum(TreeNode root) {
        ReturnType res = process(root);
        return res.maxDistance;
    }


    private ReturnType process(TreeNode cur) {
        if (cur == null) {
            return new ReturnType(0, 0);
        }

        ReturnType ldata = process(cur.left);
        ReturnType rdata = process(cur.right);


        int maxDistance = Math.max(Math.max(ldata.maxDistance, rdata.maxDistance), ldata.maxDepth + rdata.maxDepth + 1);
        int maxDepth = Math.max(ldata.maxDepth, rdata.maxDepth) + 1;

        return new ReturnType(maxDepth, maxDistance);
    }
}
