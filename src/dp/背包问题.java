package dp;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-23 下午4:30
 **/
public class 背包问题 {

/*    初始化的细节问题

    我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。有的题目要求“恰好装满背包”时的最优解，有的题目则并没有要求必须把背包装满。

    一种区别这两种问法的实现方法是在初始化的时候有所不同。

    如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。

    如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。

    为什么呢？可以这样理解：初始化的f数组事实上就是在没有任何物品可以放入背包时的合法状态。如果要求背包恰好装满，那么此时只有容量为0的背包可能

    被价值为0的nothing“恰好装满”，

    其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是-∞了。如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，

    这个解的价值为0，所以初始时状态的值也就全部为0了。*/


    // 01背包，每个东西只有一件
    public static int pack01(int[] weights, int[] values, int limit) {

/*        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
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
        return dp[weights.length][limit];*/
        // 如果用一维数组优化，循环要逆序，因为dp[j]依赖于未更新的dp[j-weights[i-1]]，所以要从后往前遍历.即本行依赖于上一行
        // 一维优化
        int[] dp = new int[limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = limit; j >= 1; j--) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[limit];
    }


    // 多重背包，多了一个nums数组，代表每个东西的数量
    public static int packMulti(int[] weights, int[] values, int[] nums, int limit) {
        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
/*        int[][] dp = new int[weights.length + 1][limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    int maxNum = Math.min(nums[i-1], j/weights[i-1]);
                    for (int k = 0; k <= maxNum; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weights[i - 1]] + values[i - 1] * k);
                    }
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][limit];*/
        int[] dp = new int[limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = limit; j >= 1; j--) {
                int maxNum = Math.min(nums[i-1], j/weights[i-1]);
                for (int k = 0; k <= maxNum; k++) {
                    if (weights[i - 1] * k <= j) {
                        // 放得下
                        dp[j] = Math.max(dp[j], dp[j - k * weights[i - 1]] + k * values[i - 1]);
                    }
                }
            }
        }
        return dp[limit];

    }

    // 完全背包，对放入的东西没有数量限制
    public static int packFull(int[] weights, int[] values, int limit) {

        //dp[i][j]表示前i件商品恰好重量为j，可以获得的最大价值，前i件不一定都要选
/*        int[][] dp = new int[weights.length + 1][limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下，可以选择一个不放也可以选择放多个因为放了第i件商品还可以继续放，所以是dp[i][j - weights[i - 1]] + values[i - 1] 而不是 dp[i - 1][j - weights[i - 1]] + values[i - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + values[i - 1]);
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][limit];*/

        int[] dp = new int[limit + 1];
        for (int i = 1; i <= weights.length; i++) {
            // 正序遍历，因为dp[j]依赖于本行的dp[j-weights[i-1]]
            for (int j = 1; j <= limit; j++) {
                if (weights[i - 1] <= j) {
                    // 放得下
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
                }
                // 放不下是dp[j]=dp[j]，可以不用写
            }
        }
        return dp[limit];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(pack01(c, p, bag));
    }
}
