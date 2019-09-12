/**
 * Author:   gucheng
 * Date:     18-4-29 下午8:13
 * Description: http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
package tree;

import support.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 */
public class 中序后序建树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 存储每个值在中序数组中的索引
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, postorder.length - 1, postorder, 0, inorder.length - 1, inorder, map);
    }

    private TreeNode helper(int postStart, int postEnd, int[] postOrder, int inStart, int inEnd, int[] inorder, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int rootIndex = map.get(root.val);
        root.left = helper(postStart, postStart + rootIndex - inStart - 1, postOrder, inStart, rootIndex - 1, inorder, map);
        root.right = helper(postStart + rootIndex - inStart, postEnd - 1, postOrder, rootIndex + 1, inEnd, inorder, map);
        return root;
    }

    public static String bianli(TreeNode cur) {
        if (cur == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                //这里加一些具体的操作
                sb.append(cur.val);
                stack.push(cur);
                pre = cur;
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return sb.toString();
    }

}
