package array;

/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array,
 *  and it should return false if every element is distinct.
 */
import java.util.HashSet;
import java.util.Set;

public class 检查是否有重复元素 {
    public boolean containsDuplicate(int[] nums) {
    	if(nums == null||nums.length==0)
    		return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums) {
        	if(!set.add(i))
        		return true;
        }
        return false;
    }
}
