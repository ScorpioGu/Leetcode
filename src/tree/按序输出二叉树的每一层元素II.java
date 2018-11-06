package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @Author gcc
 * @Date 18-11-5 上午11:08
 **/
public class 按序输出二叉树的每一层元素II {
    /**
     * DFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            //当到一个新的层级时,为该层级添加一个list,因为是从下往后遍历,所以新添加的层应该放在0位置
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - height - 1).add(root.val);
        //保证同一层级,总是左边先添加,右边元素后添加
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
    }

    /**
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每一层有一个list
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            //这里不可以写queue.size()大于0, 因为新增加的元素会改变这个值.
            //先用一个size变量保存这一层有多少个元素
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            //一层遍历结束
            res.add(0, list);
        }
        return res;
    }
}
