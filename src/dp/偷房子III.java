package dp;

import support.TreeNode;

import java.util.HashMap;

/**
 * @Desc https://leetcode.com/problems/house-robber-iii/
 * @Author gcc
 * @Date 19-1-4 下午4:20
 **/
public class 偷房子III {
    /**
     * 考虑这样一个三层结构
     *       a
     *      /  \
     *     b    c
     *    / \  / \
     *   e  f  g  h
     * 对于a这棵树,最大值应该是Math.max((b + c),(a + e+ f + g + h);
     * 那么我们用recursion(cur)方法,改方法的返回值是cur这棵树的最大值,那么要求recursion(root),就要求
     * root.left, root.right, root.left.left, root.left.right, root.right.left, root.right.right
     * 而求root.left又需要求root.left.left, root.left.right. 同理root.right也是. 那么我们可以使用一个HashMap来保存
     * 结果避免重复计算
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return recursion(root, new HashMap<>());
    }


    /**
     * 返回值是以cur为根节点的树下的最大和
     * @param cur
     * @return
     */
    private int recursion(TreeNode cur, HashMap<TreeNode, Integer> map) {
        if (cur == null) {
            return 0;
        }

        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int val = 0;
        if (cur.left != null) {
            val += recursion(cur.left.left, map) + recursion(cur.left.right, map);
        }

        if (cur.right != null) {
            val += recursion(cur.right.left, map) + recursion(cur.right.right, map);
        }

        val = Math.max(val + cur.val, recursion(cur.left, map) + recursion(cur.right, map));
        map.put(cur, val);
        return val;
    }


    public int rob2(TreeNode root) {
        int[] res = recursion(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回值的第0位存放的不选择当前点的最大值,第一位存放的是选择当前点的最大值
     * @param cur
     * @return
     */
    private int[] recursion(TreeNode cur) {
        if (cur == null) {
            return new int[2];
        }

        int[] left = recursion(cur.left);
        int[] right = recursion(cur.right);

        int[] res = new int[2];
        //如果当前节点不选,并不意味着子节点就要选
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = cur.val + left[0] + right[0];

        return res;

    }
}
