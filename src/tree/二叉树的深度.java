/**
 * Author:   gucheng
 * Date:     18-5-1 下午2:00
 * Description: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
package tree;

import support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class 二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //记录当前层级还剩余的节点个数
        int curNum = 1;
        //记录下一层级所包含的节点个数
        int nextNum = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode e = queue.poll();
            curNum--;
            if (e.left != null) {
                queue.add(e.left);
                nextNum++;
            }
            if (e.right != null) {
                queue.add(e.right);
                nextNum++;
            }
            if (curNum == 0) {
                //当前层遍历完之后，进入下一层，更新curNum,nextNum,level
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }

    public int maxDepth2(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}
