package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums == null || nums.length<3) 
    		return null;
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
        	if(i == 0 || (i>0&&nums[i] != nums[i-1])) {
        		int j=i+1; int k=nums.length-1; int sum = -nums[i];
        		while(j < k) {
            		if(nums[j] + nums[k] == sum) {
            			list.add(Arrays.asList(nums[i], nums[j], nums[k]));
            			while(j<k && nums[j]==nums[j+1]) j++;
            			while(k>j && nums[k]==nums[k-1]) k--;
            			j++;k--;
            		} else {
            			if(nums[j] + nums[k] < sum) {
            				j++;
            			} else {
            				k--;
            			}
            		}
        		}
        	}
        }
        return list;
    }
}
