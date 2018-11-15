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
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(max, total);
            //只要这一段累积出现负值了,那么这一段整体全扔了
            if (total < 0) {
                total = 0;
            }
        }
        return max;
    }
}
