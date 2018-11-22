package tree;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *    5     4       <---
 * @Author gcc
 * @Date 18-11-22 下午1:38
 **/
public class 二叉树右视图 {

    /**
     * BFS,取每层最后元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
                if (size == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    /**
     * 迭代的做法,举个例子,目前在第i层,并且当前result的size为i时,则应该把第i层的最右边的元素添加到result中
     *    1
     *  /   \
     * 2     3
     * \
     *  5
     * /
     *6
     *上面这个例子,先访问1时,填加1,然后紧接着访问3,此时result的size为1,depth为1,则将3添加到result
     * 继续访问3的右,左节点,都为null,返回.然后访问2,此时size为2,depth为1,就是说这一层已经添加过了,那么这个2将不再添加.
     * 继续访问2的右左节点,此时result的size为2,depth为2,则添加,再继续往下....
     *
     * 核心思想是,每一层只添加一个元素,让最右端的元素先被访问到,被访问到之后,result的size会发生改变,以此来判断访问的元素是否为最右端的元素.
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode cur, List<Integer> res, int depth) {
        if (cur == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(cur.val);
        }

        //必须right写在left前,保证右边的元素先被访问到
        helper(cur.right, res, depth + 1);
        helper(cur.left, res, depth + 1);
    }
}
