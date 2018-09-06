package array;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] nums, int n) {
    	int num = 0;
    	for(int i=0; i<nums.length-1 && num < n; i++) {
    		if(nums[i] == 0) {
    			int next = (i == nums.length-1)?0:nums[i+1];
    			int pre = (i == 0)?0:nums[i-1];
    			if(next == 0 && pre == 0) {
    				num++;
    				nums[i] = 1;
    			}
    		}
    	}
    	return num == n;
     }
}
