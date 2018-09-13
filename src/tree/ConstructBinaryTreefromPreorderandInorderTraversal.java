/**
 * Author:   gucheng
 * Date:     18-4-29 下午6:32
 * Description: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
package tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //可以使用map存储元素与索引的映射，免得重复的遍历
/*        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);


        }*/
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    //也可以加一个preEnd参数，便于理解，if中的判断条件可以变为preStart>preEnd || inStart > inEnd
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > inorder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        //这一块遍历是比较耗时的, 可以在前面有一个map存一下元素和坐标的索引
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, rootIndex - 1, preorder, inorder);
        root.right = helper(preStart + 1 + rootIndex - inStart, rootIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
