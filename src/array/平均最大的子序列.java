package array;

//和寻找序列中最大数意思一样，把固定长度的子序列之和作为比较的元素。
//每往右移动一个位置，变化在于nums[i]-nums[i-k]
public class 平均最大的子序列 {
    public double findMaxAverage(int[] nums, int
            k) {
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

