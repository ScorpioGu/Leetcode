package dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */
public class 买卖股票最大利润任意次 {
    public int maxProfit(int[] prices) {
    	int profit = 0;
        for(int i=1; i<prices.length; i++) {
        	profit = profit + Math.max(prices[i]-prices[i-1], 0);
        }
        return profit;
    }
}
