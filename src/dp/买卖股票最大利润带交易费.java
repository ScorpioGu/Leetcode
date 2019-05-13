package dp;

/**
 * @Desc https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @Author gcc
 * @Date 18-12-19 下午10:12
 **/
public class 买卖股票最大利润带交易费 {
    public int maxProfit(int[] prices, int fee) {
        int t1 = Integer.MIN_VALUE, t0 = 0;
        for (int price : prices) {
            // 交易费在买的时候或者卖的时候减去都是可以的
            // 如果在卖的时候扣减注意溢出，因为t1初始为min_value
            // 在买的时候扣减，不会出现这样的问题
            t0 = Math.max(t0, t1 + price);
            t1 = Math.max(t1, t0 - price - fee);
        }
        return t0;
    }
}
