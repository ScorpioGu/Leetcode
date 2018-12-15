package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5252599.html
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * @Author gcc
 * @Date 18-12-15 下午3:14
 **/
public class 二叉树最长连续序列 {
    int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, root.val, 0, list);
        return list.get(0);
    }

    private void dfs(TreeNode cur, int preVal, int consVal, List<Integer> list) {
        if (cur == null) {
            return;
        }
        if (cur.val == preVal++) {
            consVal++;
        } else {
            consVal = 1;
        }
        list.set(0, Math.max(list.get(0), consVal));
        dfs(cur.left, cur.val, consVal, list);
        dfs(cur.right, cur.val, consVal, list);
    }
}
