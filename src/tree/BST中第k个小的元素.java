package tree;

import support.TreeNode;

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
    int target;

    /**
     * 递归做法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        recursion(root, k);
        return target;
    }

    private void recursion(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        recursion(root.left, k);
        if (count++ == k) {
            target = root.val;
            return;
        }
        recursion(root.right, k);
    }
}
