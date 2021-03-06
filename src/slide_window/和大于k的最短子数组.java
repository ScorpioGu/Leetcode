package slide_window;

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
public class 和大于k的最短子数组 {
    /**
     * 就是典型的双指针的做法,时间复杂度o(n),虽然两层循环,但是指针都是往前走的.每个元素都只访问了两次
     * 注意这里给出的nums是一个正数数组，所以可以这样做
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int r = 0, l = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            int rval = nums[r];
            sum += rval;

            // from valid to invalid
            while (sum >= s) {
                int lval = nums[l];
                sum -= lval;

                minLen = Math.min(minLen, r - l + 1);

                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
