package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 */

public class 查找差值的绝对值为k的两个数的个数 {
    public int findPairs(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || k<0) 
    		return 0;
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int count = 0;
    	for(int i: nums) {
    		//存元素和它出现的次数,重复的次数只是为了处理k=0这种特殊情况
    		map.put(i, map.getOrDefault(i, 0)+1);
    	}
    	
    	for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
    		if(k == 0) {
    			if(entry.getValue()>=2) {
					count++;
				}
    		} else {
    		    //只+k,避免重复。-k也行，但是或者-k||+k。这样就会重复计算
    			if(map.containsKey(entry.getValue()+k)) {
    				count++;
    			}
    		}
    	}
    	return count;
    } 
}
