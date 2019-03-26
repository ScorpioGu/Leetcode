package tree;

import support.TreeLinkNode;

/**
 * @Desc 给定一个二叉树的其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * TreeLinkNode中的next指针指向它的父节点
 * @Author gcc
 * @Date 19-3-26 下午4:52
 **/
public class 寻找中序遍历顺序下的下一个节点 {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果存在右子树，则下一个节点是右子树中最左边的节点
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 在不存在右子树的情况下
        // 寻找这样一个节点，符合它父节点的左孩子是它自己
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        // 到这里还没找到的话，那么pNode就是中序遍历的最后一个了，下一个节点是null
        return null;
    }
}
