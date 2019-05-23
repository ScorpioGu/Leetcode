package tree;

/**
 * @Desc https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * 和每个节点的右向指针的区别在于这棵数不一定是完全二叉树
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * @Author gcc
 * @Date 18-11-6 上午11:38
 **/
public class 每个节点的右向指针II {
    /**
     * 递归做法,因为不是完全二叉树了,所以要找到同一层的下一个节点需要循环
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        //p将定位到root的右边的兄弟的第一个最左的孩子
        //所以必须要按照根，右，左的方式遍历，否则root.next将永远为null
        TreeLinkNode p = root.next;
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            } else if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        if (root.right != null) {
            root.right.next = p;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = p;
            }
        }
        //注意此处一定是先遍历递归右子树再递归左子树
        connect(root.right);
        connect(root.left);
    }

    /**
     * 非递归做法
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        //指向需要赋next指向的节点
        TreeLinkNode prev = null;
        //下一层的首个节点
        TreeLinkNode head = null;
        //用于遍历当前层级
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        //如果prev还未被指向,则当前cur是当前层级的第一个节点,且cur.left不为空,则将head指向cur.left
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
    }

    /**
     * 使用dummy指针的非递归做法
     */
    public void connect3(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        while (cur != null) {
            //这个指针是固定的,它的next指向下一层级的第一个元素
            TreeLinkNode tempChild = new TreeLinkNode();
            //currentChild负责遍历,刚开始它和tempChild指向同同一对象
            TreeLinkNode currentChild = tempChild;
            while (cur != null) {
                if (cur.left != null) {
                    tempChild.next = cur.left;
                    currentChild = currentChild.next;
                }
                if (cur.right != null) {
                    tempChild.next = cur.right;
                    currentChild = currentChild.next;
                }
                cur = cur.next;
            }
            cur = tempChild.next;
        }
    }

    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }

}
