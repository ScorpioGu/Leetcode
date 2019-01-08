package backtrack_dfs;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/combination-sum-iv/
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 * @Author gcc
 * @Date 19-1-8 下午9:34
 **/
public class 和为目标数的序列组合IV {
    /**
     * 因为这题需要返回具体的路径,只要个数即可,所以不用dfs
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, - 1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int remain, int[] dp) {
        if (dp[remain] != -1) {
            return dp[remain];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (remain >= nums[i]) {
                res += helper(nums, remain - nums[i], dp);
            }
        }
        dp[remain] = res;
        return res;
    }
}
