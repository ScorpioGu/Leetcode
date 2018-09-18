/**
 * Author:   gucheng
 * Date:     18-4-30 下午10:44
 * Description: https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
package tree;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class n个数可构成的BST列表 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }
        return helper(1, n);
    }

    //left，left+1,...,right这么多数里面组合成多棵树，存到list中返回
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (left > right) {
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            //以i为根节点，left到i-1生成几组二叉树，i+1到right生成几组二叉树。然后拼接到跟节点i上
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for (int j = 0; j < leftList.size() ; j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    //下面三行吧左右子树拼接到根节点上，每拼接一个都可以把这颗新树放到list中
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
