package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class 查找和为k的两个数 {
    public int[] twoSum(int[] numbers, int target) {
    	if(numbers == null || numbers.length == 0)
			return null;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++) {
        	if(map.containsKey(target-numbers[i])) {
        		res[0] = map.get(target-numbers[i]);
        		res[1] = i;
        		return res;
        	}
        	map.put(numbers[i], i);
        }
        return null;
    }
}
