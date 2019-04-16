package tree;

import support.TreeLinkNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack_queue space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 * @Author gcc
 * @Date 18-11-6 上午11:13
 **/
public class 每个节点的右向指针 {
    /**
     * 前序遍历，必须要前序遍历
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        //因为是完全二叉树,如果左节点存在,则右节点必然也存在,
        if (root.left != null) {
            root.left.next = root.right;
        }
        //对于右节点的next节点有两种情况,一种是父节点的next不为空,则它指向父节点的next节点的左节点,否则它指向空
        if (root.right != null) {
            if (root.next != null) {
                // 如果不是前序遍历，root.next指针将总是null
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
    }

    /**
     * 非递归做法,实际上是层次遍历,使用队列吧,但是使用队列的话空间复杂度不符合要求
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;
        //这里使用队列,不断地offer与poll来获取同层级的下一个节点,但是next指针没有被充分利用,所以带来了空间复杂度
        Deque<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeLinkNode dad = queue.poll();
                if (dad.left != null) {
                    dad.left.next = dad.right;
                    queue.offer(dad.left);
                    queue.offer(dad.right);
                }
                if (dad.right != null) {
                    if (dad.next != null) {
                        dad.right.next = dad.next.left;
                    } else {
                        dad.right.next = null;
                    }
                }
                size--;
            }
        }

    }

    public void connect3(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        //start指向当前层级的第一个节点,start.left指向下一层的第一个节点
        TreeLinkNode start = root;
        //cur指向当前层级的遍历节点,因为有next指针了,可以很方便的寻找下一个同层级节点
        TreeLinkNode cur = null;
        while (start != null) {
            cur = start;
            //层内遍历
            while (cur != null) {
                //因为是完全二叉树,所以逻辑简单了很多
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) {
                        cur.right.next = cur.next.left;
                    }
                }
                //同层级下一个节点
                cur = cur.next;
            }
            //下一层
            start = start.left;
        }
    }
}
