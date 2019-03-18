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

    //这个是一个工具方法，根据输入的中序与后序，输出前序，输入的时候分隔符是空格
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("中序：");
        String[] in = sc.nextLine().split(" ");
        System.out.println("后序：");
        String[] post = sc.nextLine().split(" ");
        int[] inOrder = new int[in.length];
        int[] postOrder = new int[post.length];
        for (int i=0; i<in.length; i++) {
            inOrder[i] = Integer.parseInt(in[i]);
            postOrder[i] = Integer.parseInt(post[i]);
        }

        TreeNode root = new 中序后序建树().buildTree(inOrder, postOrder);
        树的遍历非递归.前序(root);
    }

}
