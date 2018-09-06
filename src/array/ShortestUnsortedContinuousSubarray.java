package array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
    	int[] temp = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(temp);
    	int i=0, j=temp.length-1;
    	while(i<nums.length && nums[i] == temp[i])
    		i++;
    	while(i<j && nums[j] == temp[j])
    		j--;
    	return j-i+1;
    }
}
