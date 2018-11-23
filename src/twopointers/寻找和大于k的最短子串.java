package twopointers;

/**
 * @Desc https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * @Author gcc
 * @Date 18-11-23 下午9:29
 **/
public class 寻找和大于k的最短子串 {
    /**
     * 就是典型的双指针的做法,时间复杂度o(n),虽然两层循环,但是指针都是往前走的.每个元素都只访问了两次
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int right = 0, left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
