package findByIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 */
public class 寻找没出现过的元素列表 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<nums.length; i++) {
    		//这里要绝对值，时因为第i个元素可能在之前被取负了，减1时平移，为了元素值和元素下标能够等值映射。
    		int val = Math.abs(nums[i]) - 1;
    		//如果是负的不需要处理，说明已经有这个元素了
    		if(nums[val] > 0) {
    			nums[val] = -nums[val];
    		}
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		//大于0的，其下标平移后一定是没出现过的
    		if(nums[i]>0) {
    			list.add(i+1);
    		}
    	}
       	return list;
    }
}