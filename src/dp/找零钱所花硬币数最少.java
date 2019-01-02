package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
     * 用动态规划来做
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        //dp[i]保存金额为i时所需要的最小步数,初始化为最大,amount+1是一个不可能达到的值
        //没有必要使用二维数组dp[i][j]表示在i处金额为j的最小步数,因为dp[i][j]只来源于dp[i-1][...]
        //只需要每到一个coin去更新dp即可
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            //每轮循环,都对每一个dp[i]进行更新.如果当前的面值是coin,那么只会对大于等于coin的i有影响
            //而对小于coin的i没有影响,所以这一层循环从coin开始.同时也保证了数组不越界
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 上面的dp用的是迭代,下面用递归做做看
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return recurse(coins, amount, new int[amount]);
    }

    private int recurse(int[] coins, int remain, int[] mem) {
        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }
        if (mem[remain - 1] != 0) {
            return mem[remain - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recurse(coins, remain - coin, mem);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        mem[remain - 1] = (min == Integer.MAX_VALUE)?-1:min;
        return mem[remain - 1];
    }


    /**
     * BFS是一种较容易想到的方法,但是时间复杂度太高了,引起了TLE
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        Queue<Integer> q = new LinkedList<>();
        int dep = 0;
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer temp = q.poll();
                if (temp == amount) {
                    return dep;
                } else if (temp < amount) {
                    for (int j = 0; j < coins.length; j++) {
                        q.offer(temp + coins[j]);
                    }
                }
            }
            dep++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 找零钱所花硬币数最少().coinChange(new int[]{1}, 0));
    }
}
