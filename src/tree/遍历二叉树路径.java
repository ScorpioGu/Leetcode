package tree;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/binary-tree-paths/
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * @Author gcc
 * @Date 18-12-4 上午10:31
 **/
public class 遍历二叉树路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        backTrack(res, new LinkedList(), root);
        return res;
    }

    private void backTrack(List<String> res, List<Integer> path, TreeNode cur) {
        path.add(cur.val);

        if (cur.left == null && cur.right == null) {
            res.add(convert(path));
        }

        if (cur.left != null) {
            backTrack(res, path, cur.left);
        }

        if (cur.right != null) {
            backTrack(res, path, cur.right);
        }

        path.remove(path.size() - 1);
    }


    private String convert(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i) + "->");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }
}
