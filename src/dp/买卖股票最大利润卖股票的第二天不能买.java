package dp;

/**
 * @Desc https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * @Author gcc
 * @Date 18-12-19 下午10:13
 **/
public class 买卖股票最大利润卖股票的第二天不能买 {
    /**
     * 先简单分析一下:
     * 1.不能连续buy,不能连续sell.sell之前必须在之前有buy
     * 2.sell完之后的一天,必须rest
     * 3.buy完后的一天,可以rest也可以sell
     * 4.rest后的一天,可以继续rest,如果之前buy过,可以sell,如果之前sell过,可以buy
     * 5.最大利润一定出现在最后一天是rest或者sell的情况下,如果最后一天是buy,一定利润不是最大
     *
     * 根据以上,可以画出
     * 如https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
     * 所示的状态机
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //初始状态,刚开始就休息利润是0
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s0[0] = 0;
        //刚开始就买,利润是-prices[0]
        s1[0] = -prices[0];
        //卖完,初始化为一个最小值
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
            s2[i] = s1[i-1] + prices[i];
        }

        return Math.max(s0[s0.length - 1], s2[s2.length - 1]);
    }
}
