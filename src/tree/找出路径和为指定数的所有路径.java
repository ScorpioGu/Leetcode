/**
 * Author:   gucheng
 * Date:     18-5-1 下午5:37
 * Description: https://leetcode.com/problems/path-sum-ii/description/
 */
package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 找出路径和为指定数的所有路径 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //结果
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //保存走到当前节点的路径
        List<Integer> llist = new ArrayList<Integer>();
        helper(root, sum, list, llist);
        return list;
    }

    //一个DFS，
    private void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> llist) {
        if (root == null) {
            return;
        }
        llist.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            //当符合条件了，应新建一个内容相同的list添加，原来的llist还要继续使用。
            list.add(new ArrayList(llist));
        } else {
            helper(root.left, sum - root.val, list, llist);
            helper(root.right, sum - root.val, list, llist);
        }
        //保护进入到这个节点之前的状态
        llist.remove(llist.size() - 1);
    }
}
