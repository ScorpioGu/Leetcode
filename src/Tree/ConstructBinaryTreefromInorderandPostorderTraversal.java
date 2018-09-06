/**
 * Author:   gucheng
 * Date:     18-4-29 下午8:13
 * Description: http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
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

}
