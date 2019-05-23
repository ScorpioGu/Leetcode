package dp;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-23 下午4:30
 **/
public class 背包问题 {

    // 01背包，每个东西只有一件
    public static int pack_01(int[] weights, int[] values, int limit) {

        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
        int[][] dp = new int[weights.length + 1][limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][limit];
    }


    // 多重背包，多了一个nums数组，代表每个东西的数量
    public static int pack_many(int[] weights, int[] values, int[] nums, int limit) {
        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
        int[][] dp = new int[weights.length + 1][limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    int num = Math.min(nums[i-1], j/weights[i-1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num * weights[i - 1]] + values[i - 1] * num);
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][limit];

    }

    // 完全背包，对放入的东西没有数量限制
    public static int pack_full(int[] weights, int[] values, int limit) {

        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
        int[][] dp = new int[weights.length + 1][limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + values[i - 1]);
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][limit];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(pack_01(c, p, bag));
    }
}
