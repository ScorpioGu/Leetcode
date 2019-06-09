package prefixSum;

import support.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/path-sum-iii/
 * @Author gcc
 * @Date 19-6-9 下午5:08
 **/
public class 二叉树中和为k的路径数 {
    public int pathSum(TreeNode root, int sum) {
        // 存储前缀和，及其对应的路径数
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return helper(root, 0, sum, prefixSum);
    }

    //int count = 0;

    // 为避免全局变量，给该方法加上返回值，从低往上累加
    // 返回值为cur这棵树下（包含cur节点本身）的所有节点，和为target的路径数
    // 显然这个数目的组成 分为以当前cur节点作为路径末端的路径个数，和以cur下其他节点作为路径末端的路径的个数，
    private int helper(TreeNode cur, int curSum, int target, Map<Integer, Integer> prefixSum) {
        if (cur == null) {
            return 0;
        }
        curSum += cur.val;
/*        if (prefixSum.containsKey(curSum - target)) {
            count += prefixSum.get(curSum - target);
        }*/
        // res当前为以cur为路径末端和为target的路径个数
        int res = prefixSum.getOrDefault(curSum - target, 0);

        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        //以当前cur节点作为路径末端的路径个数加上以cur下其他节点作为路径末端的路径的个数
        res += helper(cur.left, curSum, target, prefixSum) + helper(cur.right, curSum, target, prefixSum);

        // 回溯，当前节点遍历结束了，这个前缀和不再存在了，数目要减1
        prefixSum.put(curSum, prefixSum.get(curSum) - 1);
        return res;
    }
}
