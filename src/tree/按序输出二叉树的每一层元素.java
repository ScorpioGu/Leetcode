package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @Author gcc
 * @Date 18-11-3 上午10:34
 **/
public class 按序输出二叉树的每一层元素 {
    /**
     * 使用队列,BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        //记录当前行剩余的节点数
        int cur = 1;
        //记录下一行共有多少个节点
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                res.add(new ArrayList<>(list));
                list.clear();
                cur = next;
                next = 0;
            }
        }
        return res;
    }

    /**
     * 使用队列BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
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
            res.add(list);
        }
        return res;
    }

    /**
     * 使用DFS
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;

    }

    private void helper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            //当到一个新的层级时,为该层级添加一个list
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        //保证同一层级,总是左边先添加,右边元素后添加
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
    }
}
