package array;

public class LongestContinuousIncreasingSubsequence {
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
