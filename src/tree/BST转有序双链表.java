package tree;

import support.TreeNode;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-2-27 上午11:39
 **/
public class BST转有序双链表 {

    // pre保存了前驱，初始化为null
    // pre需要是成员变量，而不能作为参数传入helper方法中，因为java中参数传递是值传递
    // helper方法递归调用，第n次helper方法中执行pre = cur对pre的指向作了修改，但是在第n-1次的helper方法中，pre的指向并不会随之发生改变
    // 也就是说，将pre作为方法参数，那么每次helper方法中，pre都为null
    // 当pre作为成员变量时，每次pre被修改，每次的helper方法中pre都会随之改变

    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 将树转成双向链表，但是pRootofTree指向不变，仍然指向根节点，需要一直向左移动
        // 直到其指向链表的头节点
        helper(pRootOfTree);

        TreeNode res = pRootOfTree;
        while (res.left != null) {
            res = res.left;
        }
        return res;
    }

    private void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 中序遍历
        helper(cur.left);

        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        }
        // 接下来cur将要指向右孩子，相应地前驱要改成当前的根节点
        pre = cur;

        helper(cur.right);
    }

}
