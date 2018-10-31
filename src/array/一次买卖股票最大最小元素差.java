package array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class 一次买卖股票最大最小元素差 {
    public int maxProfit(int[] prices) {
    	 if(prices == null || prices.length == 0)
    		 return -1;

         int local = 0;
         int global = 0;
         for(int i=1; i<prices.length; i++) {
        	 local = Math.max(local + prices[i]-prices[i-1], 0);
        	 global = Math.max(global, local);
         }
         return global;

    }

}
