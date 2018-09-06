package array;

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k)
        	return 0.0;
        double sum = 0;
        double max;
        for(int i=0; i<k; i++) {
        	sum += nums[i];
        }
        max = sum;
        
        for(int i=k; i<nums.length; i++) {
        	sum += nums[i] - nums[i-k];
        	max = Math.max(max, sum);
        }
        
        return max/1.0/k;
    }
}

