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

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, pre, res);
        if (res.size() > 0) {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }

    private void helper(TreeNode root, List<TreeNode> pre, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        helper(root.left, pre, res);
        if (pre.get(0) != null && root.val <= pre.get(0).val) {
            if (res.size() == 0) {
                res.add(pre.get(0));
                res.add(root);
            } else {
                res.set(1, root);
                return;
            }

        }
        pre.set(0, root);
        helper(root.right, pre, res);
    }
}
