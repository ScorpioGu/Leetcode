package dp;

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
public class k次买卖股票最大利润 {
    public int maxProfitK(int[] prices, int k) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int len = prices.length, profit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        //local[i][j]代表到达第i天,进行j次交易,并且要求第i天卖出股票的最大利润
        int[][] local = new int[prices.length][k + 1];
        //global[i][j]代表到达第i天,进行j次交易的最大利润
        int[][] global = new int[prices.length][k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                //全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
                //第二个量则是取local第i-1天j次交易，然后加上今天的差值,相当于本来在i-i天卖股票放到第i天卖了
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                //全局最优从过往全局最优和当前局部最优中选择,分别对应于最后一天不卖出与最后一天卖出
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][k];
    }

    /**
     * 因为存在覆盖关系,所以可以使用一维数组,注意从后往前遍历
     *
     * @param prices
     * @param k
     * @return
     */
    public int maxProfitK2(int[] prices, int k) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //local[i][j]代表到达第i天,进行j次交易,并且要求第i天卖出股票的最大利润
        int[] local = new int[k + 1];
        //global[i][j]代表到达第i天,进行j次交易的最大利润
        int[] global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                //全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
                //第二个量则是取local第i-1天j次交易，然后加上今天的差值,相当于本来在i-i天卖股票放到第i天卖了
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                //全局最优从过往全局最优和当前局部最优中选择,分别对应于最后一天不卖出与最后一天卖出
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
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
