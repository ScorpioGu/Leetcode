package tree;

import support.TreeNode;

import java.util.HashMap;

/**
 * @Desc
 * 这里的路径必须是由上到下的那种，左右的路径不行
 * @Author gcc
 * @Date 19-5-30 下午3:11
 **/
public class 二叉树中和为k的最长路径 {
    public static int getMaxLength(TreeNode head, int sum) {
        // 存储前缀和（从根节点出发），及其前缀和末端的层级
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        sumMap.put(0, 0); // important
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    private static int preOrder(TreeNode cur, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (cur == null) {
            return maxLen;
        }
        int curSum = preSum + cur.val;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        // 如果已经存在curSum，不去跟新level，因为更低的开头会带来更长的路径
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(maxLen, level - sumMap.get(curSum));
        }

        maxLen = preOrder(cur.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(cur.right, sum, curSum, level + 1, maxLen, sumMap);

        // 此时这个节点下的路径已经全部访问过，要访问其他节点了，所以要把这个节点下的前缀和给删除
        // 不同的节点下可能存在相同的前缀和，比如 1->-1->1,对应第1和第三个节点来说，前缀和都为1，根据level来判断属于自己的
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
