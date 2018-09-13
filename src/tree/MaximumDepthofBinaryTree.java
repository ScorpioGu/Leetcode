/**
 * Author:   gucheng
 * Date:     18-5-1 下午2:00
 * Description: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    /*    public int maxDepth(TreeNode root) {
            return helper(root);

        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return max(helper(root.left), helper(root.right)) + 1;
        }*/
    //非递归做法，一个BFS，使用队列辅助，队列FIFO的特性，一定是上一层级的所有节点排在下一层级节点之前。
    //没一个父节点出队列
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
}
