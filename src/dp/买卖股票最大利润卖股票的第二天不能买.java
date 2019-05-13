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
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // pre_to是前一天
        int t0 = 0, pre_t0 = 0, t1 = Integer.MIN_VALUE;
        for (int price : prices) {
            // 一进这个循环，to,t1都代表昨天的利润.用temp暂时保存昨天的to
            int temp = t0;

            t0 = Math.max(t0, t1 + price);

            // 卖完之后第二天不能买
            t1 = Math.max(t1, pre_t0 - price);

            // to,t1更新之后就是今天了,而pre_t0在下一个循环才会被用到，下一个循环中
            // 就是明天to,t1的更新会用到昨天的t0
            pre_t0 = temp;
        }
        return t0;
    }
}
