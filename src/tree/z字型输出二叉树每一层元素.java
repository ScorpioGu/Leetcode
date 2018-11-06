package tree;

import support.TreeNode;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * 依然是按层输出,但是每一层顺序并不是固定的从左到右.这题要求一层是从左往右,则下一层是从右往左.
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @Author gcc
 * @Date 18-11-5 上午9:47
 **/
public class z字型输出二叉树每一层元素 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            //每一层有一个list
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            //这里不可以写queue.size()大于0, 因为新增加的元素会改变这个值.
            //先用一个size变量保存这一层有多少个元素
            while (size > 0) {
                TreeNode node = queue.poll();
                if (order) {
                    list.add(node.val);
                } else {
                    //在指定位置插入元素,其他元素后移动
                    list.add(0, root.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            order ^= true;
            //一层遍历结束
            res.add(list);
        }
        return res;
    }
}
