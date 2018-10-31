package array;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 */
public class 序列中最长连续1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int local = 0;
        int global = 0;
        for(int i=0; i<nums.length; i++) {
        	local = nums[i] == 0?0:local+1;
        	global = Math.max(global, local);
        }
        return global;
    }
}
