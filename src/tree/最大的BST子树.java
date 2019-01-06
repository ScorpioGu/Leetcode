package tree;

import support.TreeNode;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5188938.html
 * @Author gcc
 * @Date 19-1-4 上午10:42
 **/
public class 最大的BST子树 {
    int largestBSTSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }


    private boolean isValid(TreeNode cur, int min, int max) {
        if (cur == null) {
            return true;
        }
        if (cur.val <= min || cur.val >= max) {
            return false;
        }
        return isValid(cur.left, min, cur.val) && isValid(cur.right, cur.val, max);
    }

    private int count(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        return count(cur.left) + count(cur.right) + 1;
    }
}
