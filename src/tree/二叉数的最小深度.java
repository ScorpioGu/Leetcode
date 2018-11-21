/**
 * Author:   gucheng
 * Date:     18-5-1 下午3:06
 * Description: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
package tree;

import support.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class 二叉数的最小深度 {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //如果左右子树其中一颗为空，最小深度就不能是其中两子树深度较小者+1。
        if (root.left ==null) {
            return helper(root.right) + 1;

        }

        if (root.right == null) {
            return helper(root.left) + 1;
        }

        return Math.min(helper(root.left),helper(root.right)) + 1;
    }
/*    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //按BFS的顺序入队
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //记录深度
        int level = 0;
        //记录当前层级中还剩多少节点
        int cur = 1;
        //记录下一层节点的个数
        int next = 0;
        while (!queue.isEmpty()) {
            //取出队头元素，其实就是按照BFS遍历了
            TreeNode e = queue.poll();
            cur--;
            //因为要求最小深度，又是BFS,找到的第一个节点直接返回就OK了
            if (e.right == null && e.left == null) {
                return ++level;
            }
            if (e.left != null) {
                queue.add(root.left);
                next++;
            }
            if (e.right != null) {
                queue.add(root.right);
                next++;
            }

            //当前层级的遍历结束了，cur = next 开始遍历下一个层级
            if (cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
        }
        return 0;
    }*/

}
