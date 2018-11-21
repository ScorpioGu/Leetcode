/**
 * Author:   gucheng
 * Date:     18-5-1 下午4:18
 * Description: https://leetcode.com/problems/same-tree/description/
 */
package tree;

import support.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class 判断两棵树是否相同 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //两颗树遍历到最后，都没返回false则返回true
        if (p == null && q == null) {
            return true;
        }
        //运行到此处，已经不存在两者都为null的情况，所以两个里面一个为null一个不为null也是false
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        //运行到这里说明p.val = q.val 需要进行它们子节点的比较
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
