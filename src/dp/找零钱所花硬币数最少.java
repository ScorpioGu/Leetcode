package dp;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/coin-change/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * @Author gcc
 * @Date 19-1-2 上午10:17
 **/
public class 找零钱所花硬币数最少 {
    /**
     * 如果不能够找，返回负1
     * @param nums
     * @param k
     * @return
     */
    int coinChange(int[] nums, int k) {
        // dp[i][j]代表用前0，...i凑成j的最少硬币数
        int[] dp = new int[k + 1];
        // k + 1是一个不可能的数
        Arrays.fill(dp, k + 1);
        for (int i = 0; i <= k; i++) {
            dp[i] = i % nums[0] == 0 ? i/nums[0] : k + 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= nums[i]) {
                    // 不用考虑选择当前多个硬币，因为多个硬币来源于一个个的选
                    dp[j] = Math.min(dp[j], dp[j-nums[i]] + 1);
                }
            }
        }
        return dp[k] > k ? -1 : dp[k];
    }





    public static void main(String[] args) {
        System.out.println(new 找零钱所花硬币数最少().coinChange(new int[]{1}, 0));
    }
}
