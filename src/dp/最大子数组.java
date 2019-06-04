package dp;

/**
 * @Desc https://leetcode.com/problems/maximum-subarray/description/
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * @Author gcc
 * @Date 18-11-15 下午8:32
 **/
public class 最大子数组 {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        // dp[i]为以A[i]结尾的子数组的最优解
        // 全据最优解一定是这里面的一个
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
