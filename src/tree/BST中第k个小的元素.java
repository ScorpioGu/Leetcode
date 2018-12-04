package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Desc https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @Author gcc
 * @Date 18-12-3 上午9:15
 **/
public class BST中第k个小的元素 {
    /**
     * 利用中序遍历的有序性
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (count++ == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    int count = 1;

    /**
     * 递归做法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res, k);
        return res.get(0);
    }

    private void recursion(TreeNode root, List<Integer> res, int k) {
        if (root == null) {
            return;
        }
        recursion(root.left, res, k);
        if (count++ == k) {
            res.add(root.val);
            return;
        }
        recursion(root.right, res, k);
    }
}
