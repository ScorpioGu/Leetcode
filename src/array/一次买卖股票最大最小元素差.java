package array;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

长度为n的数组，从长度为2开始，算出最大差值（数组最后一个元素作为被减数），全局最有一定在这所有的结果中。

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
