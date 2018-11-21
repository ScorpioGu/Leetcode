/**
 * Author:   gucheng
 * Date:     18-4-30 下午5:15
 * Description: https://leetcode.com/problems/recover-binary-search-tree/description/
 * 利用中序遍历的递增性，先找到倒序的地方，记录这两个节点。有两种情况，如果是相邻两节点交换了位置。那么拿到这两个节点交换就
 * 完事儿了。如果节点不相邻。通过找规律发现，四个节点，pre1, root1, pre2, root2，要交换的其实是pre1和root2。比如中序为12345的树,
 * 交换2,4变成14325,那倒叙的43,32,交换的就是4和2。发现第一祖的两个节点时，就先保存起来，如果直到最后没发现，交换这两个就可以了。
 * 如果，后面还发现了一对，则用root2替换掉root1即可。
 * 中序遍历的解释可以看validateBinarySearchTree,另外交换节点比较麻烦，要修改左右孩子节点什么的的，可以的话，直接交换节点中的数据内容。
 */
package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 */

public class BST中两个节点交换了恢复这个BST {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        //保存前驱节点
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        //保存要交换的两个节点
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, pre, res);
        //交换值即可,不需要去修改指针
        if (res.size() > 0) {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }

    //中序遍历，有序性
    private void helper(TreeNode root, List<TreeNode> pre, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        helper(root.left, pre, res);

        //对节点的操作,有两个元素位置不对,有可能是相邻的情况,也有可能是不相邻的情况
        //相邻的情况,直接交换即可.
        //不相邻的情况,比如321,第第一次发现3,2不对的时候,res中按顺序保存了3,2.第二次发现2,1不对了,则把res中的2替换成1即可
        //即321变成123,其中2是不用变化的
        if (pre.get(0) != null && root.val <= pre.get(0).val) {
            if (res.size() == 0) {
                res.add(pre.get(0));
                res.add(root);
            } else {
                //如果有两个乱序的地方，替换一下res中第二个元素
                res.set(1, root);
                //这里就直接return了,下面肯定没有乱序的了
                return;
            }

        }
        pre.set(0, root);

        helper(root.right, pre, res);
    }
}
