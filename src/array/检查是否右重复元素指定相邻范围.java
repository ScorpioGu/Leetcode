package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers and an integer k, find out whether
 *  there are two distinct indices i and j in the array such that
 *  nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class 检查是否右重复元素指定相邻范围 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums == null || nums.length < 2)
			return false;
    	//KEY为元素值，value为下标
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		if(i-map.get(nums[i]) <= k) {
        			return true;
        		} else {
        			//如果遇到有重复元素但是距离不符合条件，需要更新map，之前的那个就没用了
        			map.remove(nums[i]);
        			map.put(nums[i], i);
        		}
        	} else {
            	map.put(nums[i], i);
        	}
        }
        return false;
	}
}
