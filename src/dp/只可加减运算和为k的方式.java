package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc https://leetcode.com/problems/target-sum/
 * ou are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * @Author gcc
 * @Date 19-6-9 下午8:33
 **/
public class 只可加减运算和为k的方式 {
    public int findTargetSumWays(int[] nums, int k) {
        return dfs(0, 0, k, nums, new HashMap<>());
    }

    // 由curSum和index，决定的返回值，会带来重复计算，所以使用HashMap优化
    private int dfs(int curSum, int index, int k, int[] nums, Map<String, Integer> map) {
        String encodeString = index + "->" + curSum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length) {
            return curSum == k ? 1 : 0;
        }
        int add = dfs(curSum + nums[index], index + 1, k, nums, map);
        int minus = dfs(curSum - nums[index], index + 1, k, nums, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }


    public int findTargetSumWaysDP(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (k > sum || k < -sum) {
            return 0;
        }
        // 为避免溢出，统一加上sum, dp[][0]代表和为-sum,dp[][sum]代表和为0,dp[2*sum]代表和为sum
        // dp[i][j]为前i个数，和为j的方式个数
        int[][] dp = new int[nums.length + 1][2 *  sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= nums.length ; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i-1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + k];
    }
}
