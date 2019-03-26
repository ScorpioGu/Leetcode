package tree;

import support.TreeNode;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * <p>
 * 依然是按层输出,但是每一层顺序并不是固定的从左到右.这题要求一层是从左往右,则下一层是从右往左.
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @Author gcc
 * @Date 18-11-5 上午9:47
 **/
public class z字型输出二叉树每一层元素 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode cur, int h) {
        if (cur == null) {
            return;
        }
        if (h == res.size()) {
            res.add(new ArrayList());
        }
        List<Integer> curList = res.get(h);
        if ((h & 1) == 0) {
            curList.add(cur.val);
        } else {
            curList.add(0, cur.val);
        }
        dfs(res, cur.left, h + 1);
        dfs(res, cur.right, h + 1);
    }
}
