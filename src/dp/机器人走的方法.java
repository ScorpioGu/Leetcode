package dp;

/**
 * @Desc 一个机器人在[0,1,2...len-1]中的cur位置，一共可以走step步，最终到达end位置，问有多少种走法
 * 如果在左边界只能往右走，如果在左边界只能往左，否则两边都行
 * @Author gcc
 * @Date 19-5-29 上午11:30
 **/
public class 机器人走的方法 {
    /**
     *
     * @param len
     * @param steps
     * @param cur
     * @param end
     * @return
     */
    public int getWays(int len, int steps, int cur, int end) {
        if (len < 2 || steps < 1 || cur < 0 || cur > len - 1 || end < 0 || end > len - 1) {
            return 0;
        }
        if (steps == 0) {
            return cur == end ? 1 : 0;
        }
        if (cur == 0) {
            return getWays(len, steps - 1, cur + 1, end);
        } else if (cur == len - 1) {
            return getWays(len, steps - 1, cur - 1, end);
        } else {
            return getWays(len, steps - 1, cur - 1, end) + getWays(len, steps - 1, cur + 1, end);
        }
    }

    /**
     * steps+cur确定一个返回值，使用二维数组dp[step][cur]
     * base情况是steps == 0, cur=end为1,cur!=end为0，dp[]
     * 最终情况是dp[steps][end]
     * @param len
     * @param steps
     * @param cur
     * @param end
     * @return
     */
    public int getWaysDP(int len, int steps, int cur, int end) {
        // step在[0,steps],cur在[0,len-1]
        int[][] dp = new int[steps + 1][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = i == end ? 1 : 0;
        }
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == len - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[steps][end];
    }
}
