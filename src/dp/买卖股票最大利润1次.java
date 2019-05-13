package dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * 长度为n的数组，从长度为2开始，算出最大差值（数组最后一个元素作为被减数），全局最优一定在这所有的结果中。
 *
 * 股票问题的总结
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 */
public class 买卖股票最大利润1次 {
    public int maxProfit(int[] prices) {
        int t10 = 0, t11 = Integer.MIN_VALUE;
        for (int price : prices) {
            // 一对买卖才算一次，我们在buy的时间算次数，卖的时间不算次数
            t10 = Math.max(t10, t11 + price);
            t11 = Math.max(t11, - price);
        }
        return t10;
    }

}
