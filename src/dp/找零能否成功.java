package dp;

/**
 * @Desc 给数组nums，代表零钱，每个零钱只能用一次，问能否凑成k
 * @Author gcc
 * @Date 19-5-30 下午3:55
 **/
public class 找零能否成功 {
    public boolean isSuc(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        // dp[i][j]代表用nums 0,...i,能否凑成j
        boolean[][] dp = new boolean[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[0][i] = nums[0] == i ? true : false;
        }

        for (int i = 0; i <= k ; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
            }
        }


        return dp[nums.length - 1][k];
    }
}
