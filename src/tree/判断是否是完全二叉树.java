package tree;

import support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-22 下午5:41
 **/
public class 判断是否是完全二叉树 {
    //1.一旦出现了一个节点有右孩子但是没有左孩子，return false
    //2.一旦出现了节点的右孩子为空，后面不可以再出现任意一个不为空的节点了，如果一旦出现，返回false
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 表示是否出现了一个节点的右孩子为空
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

}
