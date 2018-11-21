package design;

import support.TreeNode;

import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/binary-search-tree-iterator/description/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 *
 * @Author gcc
 * @Date 18-11-21 上午9:51
 **/
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    /**
     * 这个时间复杂度平均o(1)平均是怎么定义的
     * @return
     */
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode node = stack.pop();
        //保证下一个最小值总是在栈顶
        TreeNode cur = node.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        return node.val;
    }
}
