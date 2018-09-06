package array;
/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
import java.util.HashMap;
import java.util.Map;

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
