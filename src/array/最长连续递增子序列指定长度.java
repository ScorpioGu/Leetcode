package array;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 */
public class 最长连续递增子序列指定长度 {
    public int findLengthOfLCIS(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
        int global = 1;
        int local = 1;
        for(int i=1; i<nums.length; i++) {
        	local = nums[i] > nums[i-1]?local+1:1;
        	global = Math.max(local, global);
        }
        return global;
    }
}
