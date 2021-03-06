package dp;

import java.util.Arrays;

/**
 * @Desc https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * @Author gcc
 * @Date 18-11-8 下午4:39
 **/
public class 买卖股票最大利润k次 {
    public int maxProfitK(int[] prices, int k) {


        // 当k >= k >= prices.length / 2, k继续增加对最大利润没有影响，因为
        // price.length这么多天里最多进行prices.length/2次交易，再多加交易次数，那只能是当前买当天卖，没有意义
        // 问题就转化为了k不设限制 的那道题
        if (k >= prices.length / 2) {
            int T1 = Integer.MIN_VALUE, T0 = 0;
            for (int price : prices) {
                T0 = Math.max(T0, T1 + price);
                T1 = Math.max(T1, T0 - price);
            }
            return T0;
        }
        // t[i]表示i次交易的最大利润
        int t0[] = new int[k + 1], t1[] = new int[k + 1];

        // 第-1天，无论多少次交易次数，手里都不能持有股票的，所以t1全部设置为min_value
        // 仅仅设置t1[0] = min_value是不行的
        Arrays.fill(t1, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                t0[i] = Math.max(t0[i], t1[i] + price);
                t1[i] = Math.max(t1[i], t0[i-1] - price);
            }
        }

        return t0[k];
    }

    public int maxProfit2(int[] prices) {
        int T10 = 0, T11 = Integer.MIN_VALUE, T20 = 0, T21 = Integer.MIN_VALUE;
        for (int price : prices) {

            // 最好是k从大到小遍历，这样不需要临时变量保存，比如T21要用到前一天的T10
            // 如果先计算今天的T10,会把昨天的T10覆盖
            T20 = Math.max(T20, T21 + price);
            T21 = Math.max(T21, T10 - price);

            T10 = Math.max(T10, T11 + price);
            T11 = Math.max(T11, - price);

        }
        return T20;
    }

    /**
     * 题目要求的两次是k次的一个特例
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //local[i][j]代表到达第i天,进行j次交易,并且要求第i天卖出股票的最大利润
        int[][] local = new int[prices.length][3];
        //global[i][j]代表到达第i天,进行j次交易的最大利润
        int[][] global = new int[prices.length][3];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                //全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
                //第二个量则是取local第i-1天j次交易，然后加上今天的差值,相当于本来在i-i天卖股票放到第i天卖了
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                //全局最优从过往全局最优和当前局部最优中选择,分别对应于最后一天不卖出与最后一天卖出
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][2];
    }
}
