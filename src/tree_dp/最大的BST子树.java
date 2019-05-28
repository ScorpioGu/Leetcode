package tree_dp;

import support.TreeNode;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5188938.html
 * 要求树中的最大BST子树，那么就求以每一个节点为根节点下的最大BST子树
 * 那么一个节点的BST子树可能来源于它的左子树，也可能来源于它的右子树，也有可能恰好自己整棵树就是BST
 * 从叶子节点往上递归到root节点，BST子树越来越大得到最优解
 * @Author gcc
 * @Date 19-1-4 上午10:42
 **/
public class 最大的BST子树 {
    private class ReturnData {
        // 该树下的最大BST的size
        int size;
        // 最大BST的头节点
        TreeNode head;
        // 这棵树的最小值与最大值
        int min;
        int max;
    }

    int largestBSTSubtree(TreeNode root) {
        ReturnData res = process(root);
        return res.size;
    }

    private ReturnData process(TreeNode cur) {
        ReturnData res = new ReturnData();
        if (cur == null) {
            res.size = 0;
            res.head = null;
            res.min = Integer.MAX_VALUE;
            res.max = Integer.MIN_VALUE;
            return res;
        }


        ReturnData ldata = process(cur.left);
        ReturnData rdata = process(cur.right);

        int includeSelf = 0;
        if (ldata.head == cur.left
                && rdata.head == cur.right
                && cur.val > ldata.max
                && cur.val < rdata.min) {
            includeSelf = ldata.size + rdata.size + 1;
        }

        res.size = Math.max(Math.max(ldata.size, rdata.size), includeSelf);
        res.head = ldata.size > rdata.size ? ldata.head : rdata.head;
        if (res.size == includeSelf) {
            res.head = cur;
        }
        res.min = Math.min(Math.min(ldata.min, rdata.min), cur.val);

        res.max = Math.max(Math.max(ldata.max, rdata.max), cur.val);

        return res;
    }


}
