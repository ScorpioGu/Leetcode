package tree_dp;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5252599.html
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 * 路径必须是父到子，增加1，比如第二个例子，路径是2-3，而不是321
 * @Author gcc
 * @Date 18-12-15 下午3:14
 **/
public class 二叉树最长连续序列 {
    int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, root.val, 0, list);
        return list.get(0);
    }

    private void dfs(TreeNode cur, int preVal, int consVal, List<Integer> list) {
        if (cur == null) {
            return;
        }
        if (cur.val == preVal++) {
            consVal++;
        } else {
            consVal = 1;
        }
        list.set(0, Math.max(list.get(0), consVal));
        dfs(cur.left, cur.val, consVal, list);
        dfs(cur.right, cur.val, consVal, list);
    }


    private class ReturnData {
        int maxLen;
        int maxLenInclude;

        public ReturnData(int maxLen, int maxLenInclude) {
            this.maxLen = maxLen;
            this.maxLenInclude = maxLenInclude;
        }
    }


    public int getMax(TreeNode root) {
        return process(root).maxLen;
    }

    private ReturnData process(TreeNode cur) {
        if (cur == null) {
            return new ReturnData(0, 0);
        }
        ReturnData ldata = process(cur.left);
        ReturnData rdata = process(cur.right);
        // 注意此处初始化为1，自己也算一个
        int maxInclude = 1;
        if (cur.left != null && cur.val == cur.left.val - 1) {
            maxInclude = Math.max(maxInclude, ldata.maxLenInclude + 1);
        }
        if (cur.right != null && cur.val == cur.right.val - 1) {
            maxInclude = Math.max(maxInclude, rdata.maxLenInclude + 1);
        }
        int maxLen = Math.max(Math.max(ldata.maxLen, rdata.maxLen), maxInclude);

        return new ReturnData(maxLen, maxInclude);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(new 二叉树最长连续序列().getMax(root));
    }
}

