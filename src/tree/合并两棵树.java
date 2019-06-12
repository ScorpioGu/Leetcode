package tree;

import support.TreeNode;

/**
 * @Desc https://leetcode.com/problems/merge-two-binary-trees/
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * @Author gcc
 * @Date 19-6-10 下午7:54
 **/
public class 合并两棵树 {
    // 一般新建一棵树，递归方法都是有返回值的，为生成的那个节点，因为不仅仅需要生成节点
    // 还要去修改生成节点的指向，带返回值即可做到。
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int sum = 0;
        if (t1 != null) {
            sum += t1.val;
        }
        if (t2 != null) {
            sum += t2.val;
        }
        TreeNode cur = new TreeNode(sum);

        cur.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        cur.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return cur;
    }
}
