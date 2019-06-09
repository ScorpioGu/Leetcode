package dp;

/**
 * @Desc https://leetcode.com/problems/partition-equal-subset-sum/
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * @Author gcc
 * @Date 19-6-9 上午11:34
 **/
public class 判断数组是否被切分为和相同的两个子数组 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        // dp[i][j]为数组前n个是否可以构成和为sum
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }
}
