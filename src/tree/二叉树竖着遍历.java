package tree;

import support.TreeNode;

import java.util.*;

/**
 * @Desc http://www.cnblogs.com/grandyang/p/5278930.html
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its vertical order traversal as:
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Given binary tree [3,9,20,4,5,2,7],
 *     _3_
 *    /   \
 *   9    20
 *  / \   / \
 * 4   5 2   7
 * @Author gcc
 * @Date 18-12-20 下午9:40
 **/
public class 二叉树竖着遍历 {
    /**
     * 层级遍历,给根节点赋予权值0,左节点的权值是父节点的权值-1,右节点为父节点的权值+1
     * 同一权值的那就是一列的
     * @param root
     * @return
     */
    List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //vals存放的是对应节点的权值,它的size永远和nodes的size保持相同
        Queue<Integer> vals = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        vals.offer(0);
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                int val = vals.poll();
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(node.val);

                if (node.left != null) {
                    vals.offer(val - 1);
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    vals.offer(val + 1);
                    nodes.offer(node.right);
                }
            }
        }
        //把map转成list,要按照顺序吧,最左边的放在前面
        List<List<Integer>> res = new LinkedList<>();
        for (int i = Collections.min(map.keySet()); i <= Collections.max(map.keySet()); i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
