package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * @Author gcc
 * @Date 18-11-2 下午8:18
 **/
public class 树的遍历递归 {
    /**
     * 以中序为例
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private void recursion(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        //如果要求前序或者后序,将这三个位置变以下即可
        recursion(node.left, res);
        res.add(node.val);
        recursion(node.right, res);
    }
}
