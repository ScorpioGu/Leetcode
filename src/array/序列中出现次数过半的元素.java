package array;
/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
//import java.util.HashMap;
//import java.util.Map;

public class 序列中出现次数过半的元素 {
	/*
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		map.put(nums[i], map.get(nums[i])+1);
        		if(map.get(nums[i])>nums.length/2)
        			return nums[i];
        	} else {
            	map.put(nums[i], 1);
        		if(map.get(nums[i])>nums.length/2)
        			return nums[i];
        	}
        }
        return 0;
    }
    */
	//每找到一对不同的元素，就删除，剩下的一定是majority元素。当遇见与majority元素相同的时候，count++，
	//不同的时候count--。当count为0，去更换majority元素。
	public int majorityElement(int[] nums) {
		int count=1;
		int majority = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==majority) 
				count++;
			else 
				count--;
			if(count==0) {
				majority = nums[i];
				count++;
			}
		}
		return majority;
	}
}
